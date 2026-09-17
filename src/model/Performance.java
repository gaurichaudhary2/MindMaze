package model;

public class Performance {

    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private double accuracy;
    private String strongestCategory;
    private String weakestCategory;
    private int currentDifficulty;

    public Performance(int totalQuestions, int correctAnswers,
                       String strongestCategory, String weakestCategory,
                       int currentDifficulty) {

        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = totalQuestions - correctAnswers;
        this.accuracy = calculateAccuracy();
        this.strongestCategory = strongestCategory;
        this.weakestCategory = weakestCategory;
        this.currentDifficulty = currentDifficulty;
    }

    private double calculateAccuracy() {
        if (totalQuestions == 0) {
            return 0.0;
        }

        return (correctAnswers * 100.0) / totalQuestions;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getStrongestCategory() {
        return strongestCategory;
    }

    public String getWeakestCategory() {
        return weakestCategory;
    }

    public int getCurrentDifficulty() {
        return currentDifficulty;
    }
}