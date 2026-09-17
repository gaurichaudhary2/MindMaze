package service;

public class AdaptiveEngine {

    private int currentDifficulty;
    private int highestUnlockedLevel;

    private int consecutiveCorrect;
    private int consecutiveIncorrect;

    public AdaptiveEngine() {

        // Player starts from Level 1
        currentDifficulty = 1;

        // Only Level 1 is unlocked initially
        highestUnlockedLevel = 1;

        consecutiveCorrect = 0;
        consecutiveIncorrect = 0;
    }

    public int getCurrentDifficulty() {
        return currentDifficulty;
    }

    public int getHighestUnlockedLevel() {
        return highestUnlockedLevel;
    }

    public String getDifficultyName() {

        switch (currentDifficulty) {

            case 1:
                return "Beginner";

            case 2:
                return "Intermediate";

            case 3:
                return "Advanced";

            default:
                return "Unknown";
        }
    }

    public boolean isLevelUnlocked(int level) {

        return level <= highestUnlockedLevel;
    }

    public boolean unlockNextLevel(int scorePercentage) {

        if (scorePercentage >= 60
                && highestUnlockedLevel < 3) {

            highestUnlockedLevel++;

            return true;
        }

        return false;
    }

    public boolean moveToLevel(int level) {

        if (isLevelUnlocked(level)) {

            currentDifficulty = level;

            consecutiveCorrect = 0;
            consecutiveIncorrect = 0;

            return true;
        }

        return false;
    }

    public void recordAnswer(boolean correct) {

        if (correct) {

            consecutiveCorrect++;
            consecutiveIncorrect = 0;

            // 2 consecutive correct answers
            // increase difficulty inside the current level
            if (consecutiveCorrect >= 2) {

                increaseDifficulty();

                consecutiveCorrect = 0;
            }

        } else {

            consecutiveIncorrect++;
            consecutiveCorrect = 0;

            // 2 consecutive incorrect answers
            // decrease difficulty
            if (consecutiveIncorrect >= 2) {

                decreaseDifficulty();

                consecutiveIncorrect = 0;
            }
        }
    }

    private void increaseDifficulty() {

        if (currentDifficulty < highestUnlockedLevel) {

            currentDifficulty++;
        }
    }

    private void decreaseDifficulty() {

        if (currentDifficulty > 1) {

            currentDifficulty--;
        }
    }

    public void resetProgress() {

        currentDifficulty = 1;
        highestUnlockedLevel = 1;

        consecutiveCorrect = 0;
        consecutiveIncorrect = 0;
    }
}