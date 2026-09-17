package util;

import model.Attempt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String FILE_NAME = "data/history.txt";

    public void saveAttempt(Attempt attempt) {

        try {

            File file = new File(FILE_NAME);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            FileWriter writer = new FileWriter(file, true);

            writer.write(
                    "Category: " + attempt.getCategory()
                            + " | Questions: " + attempt.getTotalQuestions()
                            + " | Correct: " + attempt.getCorrectAnswers()
                            + " | Accuracy: "
                            + String.format("%.2f", attempt.getAccuracy())
                            + "% | Difficulty: "
                            + attempt.getFinalDifficulty()
                            + " | Date: "
                            + attempt.getDateTime()
                            + System.lineSeparator()
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Unable to save attempt history."
            );
        }
    }
}