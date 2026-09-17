package service;

import model.Puzzle;

public class ScoringEngine {

    public int calculateScore(Puzzle puzzle, boolean correct) {

        if (!correct) {
            return 0;
        }

        switch (puzzle.getDifficulty()) {

            case 1:
                return 10;

            case 2:
                return 20;

            case 3:
                return 30;

            default:
                return 0;
        }
    }

    public int calculatePercentage(
            int correctAnswers,
            int totalQuestions) {

        if (totalQuestions == 0) {
            return 0;
        }

        return (correctAnswers * 100) / totalQuestions;
    }

    public String getScoreMessage(int percentage) {

        if (percentage >= 90) {
            return "Excellent performance!";
        }

        if (percentage >= 75) {
            return "Great performance!";
        }

        if (percentage >= 60) {
            return "Good! You can unlock the next level.";
        }

        return "Keep practicing and try again!";
    }
}