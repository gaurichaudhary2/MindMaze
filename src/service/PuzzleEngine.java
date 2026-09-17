package service;

import model.Puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleEngine {

    private List<Puzzle> puzzles;

    public PuzzleEngine() {
        puzzles = new ArrayList<>();
        loadPuzzles();
    }

    private void loadPuzzles() {

        // ================= LEVEL 1 : BEGINNER =================

        // Pattern Recognition
        puzzles.add(new Puzzle(
                1, "Pattern Recognition",
                "Find the next number: 2, 4, 6, 8, ?",
                new String[]{"9", "10", "11", "12"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                2, "Pattern Recognition",
                "Find the next number: 5, 10, 15, 20, ?",
                new String[]{"22", "24", "25", "30"}, 3, 1
        ));

        puzzles.add(new Puzzle(
                3, "Pattern Recognition",
                "Find the next number: 10, 20, 30, 40, ?",
                new String[]{"45", "50", "55", "60"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                4, "Pattern Recognition",
                "Find the next number: 1, 3, 5, 7, ?",
                new String[]{"8", "9", "10", "11"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                5, "Pattern Recognition",
                "Find the next number: 10, 15, 20, 25, ?",
                new String[]{"28", "30", "32", "35"}, 2, 1
        ));

        // Logical Reasoning
        puzzles.add(new Puzzle(
                6, "Logical Reasoning",
                "If all dogs are animals, which statement is definitely true?",
                new String[]{
                        "All animals are dogs",
                        "All dogs are animals",
                        "No dogs are animals",
                        "Some animals are not dogs"
                }, 2, 1
        ));

        puzzles.add(new Puzzle(
                7, "Logical Reasoning",
                "A is taller than B. B is taller than C. Who is shortest?",
                new String[]{"A", "B", "C", "Cannot say"}, 3, 1
        ));

        puzzles.add(new Puzzle(
                8, "Logical Reasoning",
                "Which one is different from the others?",
                new String[]{"Apple", "Mango", "Carrot", "Banana"}, 3, 1
        ));

        puzzles.add(new Puzzle(
                9, "Logical Reasoning",
                "If today is Monday, what day will it be after 2 days?",
                new String[]{"Tuesday", "Wednesday", "Thursday", "Friday"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                10, "Logical Reasoning",
                "Which comes first in alphabetical order?",
                new String[]{"Ball", "Apple", "Cat", "Dog"}, 2, 1
        ));

        // Numerical Reasoning
        puzzles.add(new Puzzle(
                11, "Numerical Reasoning",
                "What is 10% of 100?",
                new String[]{"5", "10", "15", "20"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                12, "Numerical Reasoning",
                "What is 15 + 25?",
                new String[]{"30", "35", "40", "45"}, 3, 1
        ));

        puzzles.add(new Puzzle(
                13, "Numerical Reasoning",
                "What is 8 × 5?",
                new String[]{"35", "40", "45", "50"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                14, "Numerical Reasoning",
                "What is 100 ÷ 4?",
                new String[]{"20", "25", "30", "40"}, 2, 1
        ));

        puzzles.add(new Puzzle(
                15, "Numerical Reasoning",
                "If one pen costs ₹10, how much do 5 pens cost?",
                new String[]{"₹40", "₹45", "₹50", "₹55"}, 3, 1
        ));


        // ================= LEVEL 2 : INTERMEDIATE =================

        puzzles.add(new Puzzle(
                16, "Pattern Recognition",
                "Find the next number: 3, 6, 12, 24, ?",
                new String[]{"36", "42", "48", "54"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                17, "Pattern Recognition",
                "Find the next number: 2, 6, 12, 20, ?",
                new String[]{"24", "28", "30", "32"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                18, "Pattern Recognition",
                "Find the next number: 1, 4, 9, 16, ?",
                new String[]{"20", "24", "25", "30"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                19, "Pattern Recognition",
                "Find the next number: 100, 90, 80, 70, ?",
                new String[]{"50", "55", "60", "65"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                20, "Pattern Recognition",
                "Find the next number: 2, 5, 10, 17, ?",
                new String[]{"24", "25", "26", "27"}, 4, 2
        ));

        puzzles.add(new Puzzle(
                21, "Logical Reasoning",
                "If all roses are flowers and some flowers fade quickly, what is definitely true?",
                new String[]{
                        "All roses fade quickly",
                        "Some roses fade quickly",
                        "All roses are flowers",
                        "No roses are flowers"
                }, 3, 2
        ));

        puzzles.add(new Puzzle(
                22, "Logical Reasoning",
                "A person walks 5 km north and then 5 km east. In which direction is the person from the starting point?",
                new String[]{"North", "East", "North-East", "South-East"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                23, "Logical Reasoning",
                "If P is older than Q and Q is older than R, which is true?",
                new String[]{
                        "R is older than P",
                        "P is older than R",
                        "P and R are same age",
                        "Cannot determine"
                }, 2, 2
        ));

        puzzles.add(new Puzzle(
                24, "Logical Reasoning",
                "A clock shows 3:00. What is the angle between its hands?",
                new String[]{"45°", "60°", "90°", "120°"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                25, "Logical Reasoning",
                "If BOOK is coded as CPPL, how is PEN coded?",
                new String[]{"QFO", "QEN", "PFO", "QFN"}, 1, 2
        ));

        puzzles.add(new Puzzle(
                26, "Numerical Reasoning",
                "What is 20% of 250?",
                new String[]{"40", "50", "60", "70"}, 2, 2
        ));

        puzzles.add(new Puzzle(
                27, "Numerical Reasoning",
                "A shirt costs ₹500. After a 10% discount, what is the price?",
                new String[]{"₹450", "₹460", "₹475", "₹490"}, 1, 2
        ));

        puzzles.add(new Puzzle(
                28, "Numerical Reasoning",
                "If 5 notebooks cost ₹100, what is the cost of 8 notebooks?",
                new String[]{"₹120", "₹140", "₹160", "₹180"}, 3, 2
        ));

        puzzles.add(new Puzzle(
                29, "Numerical Reasoning",
                "The average of 10 and 20 is:",
                new String[]{"12", "15", "18", "20"}, 2, 2
        ));

        puzzles.add(new Puzzle(
                30, "Numerical Reasoning",
                "A number increased by 20% becomes 120. What was the original number?",
                new String[]{"90", "100", "110", "115"}, 2, 2
        ));


        // ================= LEVEL 3 : ADVANCED =================

        puzzles.add(new Puzzle(
                31, "Pattern Recognition",
                "Find the next number: 2, 6, 12, 20, 30, ?",
                new String[]{"36", "40", "42", "44"}, 3, 3
        ));

        puzzles.add(new Puzzle(
                32, "Pattern Recognition",
                "Find the next number: 1, 2, 6, 24, ?",
                new String[]{"60", "100", "120", "144"}, 3, 3
        ));

        puzzles.add(new Puzzle(
                33, "Pattern Recognition",
                "Find the next number: 4, 9, 19, 39, ?",
                new String[]{"69", "79", "89", "99"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                34, "Pattern Recognition",
                "Find the next number: 7, 14, 28, 56, ?",
                new String[]{"84", "98", "112", "120"}, 3, 3
        ));

        puzzles.add(new Puzzle(
                35, "Pattern Recognition",
                "Find the next number: 3, 8, 15, 24, 35, ?",
                new String[]{"46", "48", "50", "52"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                36, "Logical Reasoning",
                "If some A are B and all B are C, which statement must be true?",
                new String[]{
                        "Some A are C",
                        "All A are C",
                        "No A are C",
                        "All C are A"
                }, 1, 3
        ));

        puzzles.add(new Puzzle(
                37, "Logical Reasoning",
                "A person faces north, turns right, then right again. Which direction is the person facing?",
                new String[]{"North", "South", "East", "West"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                38, "Logical Reasoning",
                "If CAT is coded as DBU, how is DOG coded?",
                new String[]{"EPH", "EOH", "FPH", "DPG"}, 1, 3
        ));

        puzzles.add(new Puzzle(
                39, "Logical Reasoning",
                "Three people A, B and C stand in a line. A is not first. C is not last. Who can be first?",
                new String[]{"A only", "B only", "C only", "B or C"}, 4, 3
        ));

        puzzles.add(new Puzzle(
                40, "Logical Reasoning",
                "If today is Wednesday, what day will it be after 100 days?",
                new String[]{"Thursday", "Friday", "Saturday", "Sunday"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                41, "Numerical Reasoning",
                "A number is increased by 25% and becomes 250. What was the original number?",
                new String[]{"180", "200", "220", "225"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                42, "Numerical Reasoning",
                "The ratio of A:B is 3:5. If A is 24, what is B?",
                new String[]{"30", "36", "40", "45"}, 3, 3
        ));

        puzzles.add(new Puzzle(
                43, "Numerical Reasoning",
                "A train travels 240 km in 4 hours. What is its average speed?",
                new String[]{"50 km/h", "60 km/h", "70 km/h", "80 km/h"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                44, "Numerical Reasoning",
                "If the price of an item increases from ₹800 to ₹1000, what is the percentage increase?",
                new String[]{"20%", "25%", "30%", "40%"}, 2, 3
        ));

        puzzles.add(new Puzzle(
                45, "Numerical Reasoning",
                "The average of 5 numbers is 20. What is their total?",
                new String[]{"80", "90", "100", "120"}, 3, 3
        ));
    }

    public List<Puzzle> getPuzzlesByDifficulty(int difficulty) {

        List<Puzzle> result = new ArrayList<>();

        for (Puzzle puzzle : puzzles) {
            if (puzzle.getDifficulty() == difficulty) {
                result.add(puzzle);
            }
        }

        Collections.shuffle(result);

        return result;
    }

    public List<Puzzle> getPuzzlesByCategory(String category) {

        List<Puzzle> result = new ArrayList<>();

        for (Puzzle puzzle : puzzles) {
            if (puzzle.getCategory().equalsIgnoreCase(category)) {
                result.add(puzzle);
            }
        }

        Collections.shuffle(result);

        return result;
    }

    public List<Puzzle> getPuzzlesByCategoryAndDifficulty(
            String category, int difficulty) {

        List<Puzzle> result = new ArrayList<>();

        for (Puzzle puzzle : puzzles) {

            if (puzzle.getCategory().equalsIgnoreCase(category)
                    && puzzle.getDifficulty() == difficulty) {

                result.add(puzzle);
            }
        }

        Collections.shuffle(result);

        return result;
    }

    public List<Puzzle> getAllPuzzles() {
        return new ArrayList<>(puzzles);
    }
}