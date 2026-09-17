package model;

import java.time.LocalDateTime;

public class Attempt {

    private int totalQuestions;
    private int correctAnswers;
    private String category;
    private int finalDifficulty;
    private LocalDateTime dateTime;

    public Attempt(int totalQuestions, int correctAnswers,
                   String category, int finalDifficulty) {

        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.category = category;
        this.finalDifficulty = finalDifficulty;
        this.dateTime = LocalDateTime.now();
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public String getCategory() {
        return category;
    }

    public int getFinalDifficulty() {
        return finalDifficulty;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getAccuracy() {
        if (totalQuestions == 0) {
            return 0.0;
        }

        return (correctAnswers * 100.0) / totalQuestions;
    }
}