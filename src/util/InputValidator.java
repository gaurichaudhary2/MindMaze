package util;

import java.util.Scanner;

public class InputValidator {

    public static int getIntegerInput(
            Scanner scanner, int min, int max) {

        while (true) {

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();

                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                scanner.next();
            }

            System.out.println(
                    "Invalid input! Please enter a number between "
                            + min + " and " + max + "."
            );
        }
    }

    public static String getNonEmptyString(Scanner scanner) {

        while (true) {

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again:");
        }
    }
}