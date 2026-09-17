package model;

public class User {

    private String name;
    private int totalQuestions;
    private int correctAnswers;

    public User(String name) {
        this.name = name;
        this.totalQuestions = 0;
        this.correctAnswers = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void addResult(boolean correct) {
        totalQuestions++;

        if (correct) {
            correctAnswers++;
        }
    }

    public double getAccuracy() {
        if (totalQuestions == 0) {
            return 0.0;
        }

        return (correctAnswers * 100.0) / totalQuestions;
    }
}