import model.Attempt;
import model.Puzzle;
import model.User;
import service.AdaptiveEngine;
import service.AnalyticsEngine;
import service.PuzzleEngine;
import service.ScoringEngine;
import util.FileManager;
import util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static User user;
    private static AdaptiveEngine adaptiveEngine;
    private static PuzzleEngine puzzleEngine;
    private static ScoringEngine scoringEngine;
    private static AnalyticsEngine analyticsEngine;
    private static FileManager fileManager;

    private static int totalQuestions = 0;
    private static int correctAnswers = 0;
    private static int totalScore = 0;

    private static Map<String, Integer> categoryResults;

    public static void main(String[] args) {

        initializeSystem();

        showWelcome();

        createUser();

        boolean running = true;

        while (running) {

            showMainMenu();

            int choice =
                    InputValidator.getIntegerInput(scanner, 1, 5);

            scanner.nextLine();

            switch (choice) {

                case 1:
                    levelMenu();
                    break;

                case 2:
                    showPerformance();
                    break;

                case 3:
                    showHistoryInfo();
                    break;

                case 4:
                    showProjectInfo();
                    break;

                case 5:
                    running = false;
                    System.out.println(
                            "\nThank you for playing MindMaze!"
                    );
                    break;
            }
        }

        scanner.close();
    }

    private static void initializeSystem() {

        adaptiveEngine = new AdaptiveEngine();
        puzzleEngine = new PuzzleEngine();
        scoringEngine = new ScoringEngine();
        analyticsEngine = new AnalyticsEngine();
        fileManager = new FileManager();

        categoryResults =
                analyticsEngine.createCategoryMap();
    }

    private static void showWelcome() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              M I N D M A Z E");
        System.out.println("       Adaptive Reasoning Challenge");
        System.out.println("==========================================");
    }

    private static void createUser() {

        System.out.print("\nEnter your name: ");

        String name =
                InputValidator.getNonEmptyString(scanner);

        user = new User(name);

        System.out.println(
                "\nWelcome to MindMaze, "
                        + user.getName() + "!"
        );
    }

    private static void showMainMenu() {

        System.out.println();
        System.out.println("============== MAIN MENU ================");
        System.out.println("Player : " + user.getName());
        System.out.println(
                "Unlocked Level : "
                        + adaptiveEngine.getHighestUnlockedLevel()
        );
        System.out.println("------------------------------------------");
        System.out.println("1. Play MindMaze");
        System.out.println("2. Performance Report");
        System.out.println("3. Assessment History");
        System.out.println("4. About MindMaze");
        System.out.println("5. Exit");
        System.out.println("==========================================");
        System.out.print("Enter your choice: ");
    }

    // ================= LEVEL MENU =================

    private static void levelMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("============= LEVEL SELECT =============");

            for (int level = 1; level <= 3; level++) {

                if (adaptiveEngine.isLevelUnlocked(level)) {

                    System.out.println(
                            level + ". "
                                    + getLevelName(level)
                                    + "  [UNLOCKED]"
                    );

                } else {

                    System.out.println(
                            level + ". "
                                    + getLevelName(level)
                                    + "  [LOCKED]"
                    );
                }
            }

            System.out.println("4. Back to Main Menu");
            System.out.println("=========================================");
            System.out.print("Choose level: ");

            int choice =
                    InputValidator.getIntegerInput(
                            scanner, 1, 4
                    );

            scanner.nextLine();

            if (choice == 4) {

                back = true;

            } else if (
                    adaptiveEngine.isLevelUnlocked(choice)
            ) {

                adaptiveEngine.moveToLevel(choice);

                categoryMenu();

            } else {

                System.out.println();
                System.out.println(
                        "🔒 This level is locked."
                );
                System.out.println(
                        "Complete the previous level with "
                                + "at least 60% accuracy to unlock it."
                );
            }
        }
    }

    private static String getLevelName(int level) {

        switch (level) {

            case 1:
                return "LEVEL 1 - BEGINNER";

            case 2:
                return "LEVEL 2 - INTERMEDIATE";

            case 3:
                return "LEVEL 3 - ADVANCED";

            default:
                return "UNKNOWN LEVEL";
        }
    }

    // ================= CATEGORY MENU =================

    private static void categoryMenu() {

        System.out.println();
        System.out.println(
                "========= " +
                        getLevelName(
                                adaptiveEngine.getCurrentDifficulty()
                        )
                        + " ========="
        );

        System.out.println(
                "1. Pattern Recognition"
        );
        System.out.println(
                "2. Logical Reasoning"
        );
        System.out.println(
                "3. Numerical Reasoning"
        );
        System.out.println(
                "4. Mixed Challenge"
        );
        System.out.println(
                "5. Back"
        );

        System.out.print("Choose category: ");

        int choice =
                InputValidator.getIntegerInput(
                        scanner, 1, 5
                );

        scanner.nextLine();

        if (choice == 5) {
            return;
        }

        String category =
                getCategoryName(choice);

        startChallenge(category);
    }

    private static String getCategoryName(int choice) {

        switch (choice) {

            case 1:
                return "Pattern Recognition";

            case 2:
                return "Logical Reasoning";

            case 3:
                return "Numerical Reasoning";

            case 4:
                return "Mixed Challenge";

            default:
                return "Mixed Challenge";
        }
    }

    // ================= CHALLENGE =================

    private static void startChallenge(String category) {

        int selectedLevel =
                adaptiveEngine.getCurrentDifficulty();

        List<Puzzle> questions;

        if (category.equals("Mixed Challenge")) {

            questions =
                    puzzleEngine.getPuzzlesByDifficulty(
                            selectedLevel
                    );

        } else {

            questions =
                    puzzleEngine
                            .getPuzzlesByCategoryAndDifficulty(
                                    category,
                                    selectedLevel
                            );
        }

        if (questions.isEmpty()) {

            System.out.println(
                    "\nNo questions available."
            );

            return;
        }

        /*
         * Each challenge contains 5 questions.
         */

        int questionLimit =
                Math.min(5, questions.size());

        int challengeCorrect = 0;
        int challengeScore = 0;

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          CHALLENGE STARTED");
        System.out.println("Level    : "
                + getLevelName(selectedLevel));
        System.out.println("Category : " + category);
        System.out.println("Questions: " + questionLimit);
        System.out.println("==========================================");

        for (int i = 0; i < questionLimit; i++) {

            Puzzle puzzle = questions.get(i);

            System.out.println();
            System.out.println(
                    "Question " + (i + 1)
                            + " of " + questionLimit
            );

            boolean correct =
                    askQuestion(puzzle);

            user.addResult(correct);

            totalQuestions++;

            if (correct) {

                correctAnswers++;
                challengeCorrect++;

                analyticsEngine.recordCategoryResult(
                        categoryResults,
                        puzzle.getCategory(),
                        true
                );

            } else {

                analyticsEngine.recordCategoryResult(
                        categoryResults,
                        puzzle.getCategory(),
                        false
                );
            }

            int score =
                    scoringEngine.calculateScore(
                            puzzle,
                            correct
                    );

            challengeScore += score;
            totalScore += score;

            /*
             * Adaptive engine observes every answer.
             */
            adaptiveEngine.recordAnswer(correct);
        }

        int percentage =
                (challengeCorrect * 100) / questionLimit;

        Attempt attempt =
                new Attempt(
                        questionLimit,
                        challengeCorrect,
                        category,
                        selectedLevel
                );

        fileManager.saveAttempt(attempt);

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          CHALLENGE COMPLETE");
        System.out.println("==========================================");
        System.out.println(
                "Correct Answers : "
                        + challengeCorrect
                        + "/" + questionLimit
        );
        System.out.println(
                "Accuracy        : "
                        + percentage + "%"
        );
        System.out.println(
                "Score Earned    : "
                        + challengeScore
        );
        System.out.println(
                "==========================================");

        /*
         * Level unlocking.
         */
        if (percentage >= 60
                && selectedLevel
                == adaptiveEngine.getHighestUnlockedLevel()
                && selectedLevel < 3) {

            boolean unlocked =
                    adaptiveEngine.unlockNextLevel(
                            percentage
                    );

            if (unlocked) {

                System.out.println();
                System.out.println(
                        "🎉 LEVEL "
                                + adaptiveEngine
                                .getHighestUnlockedLevel()
                                + " UNLOCKED!"
                );

                System.out.println(
                        "Keep going and test your reasoning skills."
                );
            }

        } else if (percentage < 60) {

            System.out.println();
            System.out.println(
                    "You need at least 60% to unlock "
                            + "the next level."
            );

            System.out.println(
                    "Retry this level and improve your score!"
            );
        }

        System.out.println();
        System.out.println(
                "Current Adaptive Level: "
                        + adaptiveEngine.getDifficultyName()
        );
    }

    // ================= QUESTION =================

    private static boolean askQuestion(Puzzle puzzle) {

        System.out.println("------------------------------------------");
        System.out.println(puzzle.getQuestion());
        System.out.println("------------------------------------------");

        String[] options =
                puzzle.getOptions();

        for (int i = 0; i < options.length; i++) {

            System.out.println(
                    (i + 1) + ". " + options[i]
            );
        }

        System.out.print("Your answer: ");

        int answer =
                InputValidator.getIntegerInput(
                        scanner,
                        1,
                        options.length
                );

        scanner.nextLine();

        boolean correct =
                puzzle.checkAnswer(answer);

        if (correct) {

            System.out.println(
                    "✓ Correct!"
            );

        } else {

            System.out.println(
                    "✗ Incorrect!"
            );

            System.out.println(
                    "Correct Answer: "
                            + options[
                            puzzle.getCorrectAnswer() - 1
                            ]
            );
        }

        return correct;
    }

    // ================= PERFORMANCE =================

    private static void showPerformance() {

        String strongest =
                findStrongestCategory();

        String weakest =
                findWeakestCategory();

        analyticsEngine.displaySummary(
                totalQuestions,
                correctAnswers,
                totalScore,
                strongest,
                weakest,
                adaptiveEngine.getDifficultyName()
        );

        System.out.println(
                "Highest Unlocked Level : "
                        + adaptiveEngine
                        .getHighestUnlockedLevel()
        );
    }

    private static String findStrongestCategory() {

        if (categoryResults.isEmpty()) {
            return "No data yet";
        }

        String strongest = "No data";
        int highest = -1;

        for (Map.Entry<String, Integer> entry
                : categoryResults.entrySet()) {

            if (entry.getValue() > highest) {

                highest = entry.getValue();
                strongest = entry.getKey();
            }
        }

        return strongest;
    }

    private static String findWeakestCategory() {

        if (categoryResults.isEmpty()) {
            return "No data yet";
        }

        String weakest = "No data";
        int lowest = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry
                : categoryResults.entrySet()) {

            if (entry.getValue() < lowest) {

                lowest = entry.getValue();
                weakest = entry.getKey();
            }
        }

        return weakest;
    }

    // ================= HISTORY =================

    private static void showHistoryInfo() {

        System.out.println();
        System.out.println("========== ASSESSMENT HISTORY ==========");

        System.out.println(
                "Completed challenges are stored in:"
        );

        System.out.println(
                "data/history.txt"
        );

        System.out.println();

        System.out.println(
                "Challenges completed: "
                        + countChallenges()
        );

        System.out.println(
                "========================================="
        );
    }

    private static int countChallenges() {

        if (totalQuestions == 0) {
            return 0;
        }

        return (int) Math.ceil(
                totalQuestions / 5.0
        );
    }

    // ================= ABOUT =================

    private static void showProjectInfo() {

        System.out.println();
        System.out.println("============== ABOUT MINDMAZE ===========");

        System.out.println(
                "MindMaze is an adaptive reasoning"
        );

        System.out.println(
                "and puzzle assessment system."
        );

        System.out.println();

        System.out.println(
                "Players progress through three levels:"
        );

        System.out.println(
                "Level 1 → Beginner"
        );

        System.out.println(
                "Level 2 → Intermediate"
        );

        System.out.println(
                "Level 3 → Advanced"
        );

        System.out.println();

        System.out.println(
                "The system analyses performance and"
        );

        System.out.println(
                "adjusts the challenge difficulty."
        );

        System.out.println(
                "========================================="
        );
    }
}