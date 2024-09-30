package org.example;

import org.example.exception.JsonParseException;
import org.example.util.JsonParserUtil;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    public static void main(String[] args) throws JsonParseException {
        // Create a scanner object to accept user input
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter a valid JSON string to parse:");
            String userInput = scanner.nextLine();  // Read user input
            // Validate non-empty input
            if (userInput == null || userInput.trim().isEmpty()) {
                System.err.println("Error: Empty input. Please provide a valid JSON string.");
                continue;
            }
            // Try to parse the input JSON string
            try {
                Object parsedResult = JsonParserUtil.parseJson(userInput);
                System.out.println("Parsed Result: " + parsedResult);
            } catch (Exception e) {
                // Print user-friendly error message
                System.err.println("Error: Failed to parse JSON string");
            }
        }
    }
}
