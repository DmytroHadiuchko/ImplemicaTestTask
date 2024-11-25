package org.example;

import java.util.Scanner;

public class FirstTask {

    // This method calculates the nth Catalan number using the formula:
    // C(n) = (2n)! / ((n + 1)! * n!)
    public static long calculateCatalan(int n) {
        // Base case: if n is 0, the Catalan number is 1
        if (n == 0) {
            return 1;
        }

        // Calculate the numerator (2n)!
        long numerator = factorial(2 * n);
        // Calculate the denominator (n + 1)! * n!
        long denominator = factorial(n + 1) * factorial(n);
        // Return the Catalan number by dividing numerator by denominator
        return numerator / denominator;
    }

    // This method calculates the factorial of a number 'num'
    public static long factorial(int num) {
        long result = 1;
        // Loop to calculate the factorial
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of bracket pairs
        System.out.print("Please, Enter the number of bracket pairs ");
        int n = scanner.nextInt();

        // Check if the entered number is valid (non-negative)
        if (n < 0) {
            // If n is negative, print an error message
            System.out.println("N must be not negative number.");
        } else {
            // Calculate the nth Catalan number for valid input
            long catalanNumber = calculateCatalan(n);
            // Output the result
            System.out.println("The number of correct parentheses is expressed for N = " + n + ": " + catalanNumber);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
