package service;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnalyticsEngine {

    private final Map<String, Integer> categoryAttempts = new LinkedHashMap<>();
    private final Map<String, Integer> categoryCorrect = new LinkedHashMap<>();

    public Map<String, Integer> createCategoryMap() {
        Map<String, Integer> categoryMap = new LinkedHashMap<>();

        categoryMap.put("Pattern Recognition", 0);
        categoryMap.put("Logical Reasoning", 0);
        categoryMap.put("Numerical Reasoning", 0);

        return categoryMap;
    }

    public void recordCategoryResult(
            Map<String, Integer> categoryResults,
            String category,
            boolean correct) {

        categoryAttempts.put(
                category,
                categoryAttempts.getOrDefault(category, 0) + 1
        );

        if (correct) {
            categoryCorrect.put(
                    category,
                    categoryCorrect.getOrDefault(category, 0) + 1
            );
        }

        int attempts = categoryAttempts.get(category);
        int correctAnswers = categoryCorrect.getOrDefault(category, 0);

        int percentage = (correctAnswers * 100) / attempts;

        categoryResults.put(category, percentage);
    }

    public void displaySummary(
            int totalQuestions,
            int correctAnswers,
            int totalScore,
            String strongestCategory,
            String weakestCategory,
            String currentDifficulty) {

        int accuracy = 0;

        if (totalQuestions > 0) {
            accuracy = (correctAnswers * 100) / totalQuestions;
        }

        System.out.println("\n======================================");
        System.out.println("         PERFORMANCE SUMMARY");
        System.out.println("======================================");

        System.out.println("Total Questions : " + totalQuestions);
        System.out.println("Correct Answers : " + correctAnswers);
        System.out.println("Accuracy        : " + accuracy + "%");
        System.out.println("Total Score     : " + totalScore);
        System.out.println("Strongest Area  : " + strongestCategory);
        System.out.println("Weakest Area    : " + weakestCategory);
        System.out.println("Adaptive Level  : " + currentDifficulty);

        System.out.println("======================================\n");
    }
}