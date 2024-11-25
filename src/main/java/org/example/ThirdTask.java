package org.example;

import java.math.BigInteger;

public class ThirdTask {
    public static void main(String[] args) {
        // Define the value of n (100 in this case)
        int n = 100;

        // Initialize the factorial value to 1 (since the factorial of 0 and 1 is 1)
        BigInteger factorial = BigInteger.ONE;

        // Loop from 2 to n (100) to calculate the factorial of n
        for (int i = 2; i <= n; i++) {
            // Multiply the current factorial value by i at each iteration
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Convert the calculated factorial value to a string
        String factorialStr = factorial.toString();

        // Initialize a variable to store the sum of digits of the factorial
        int sum = 0;

        // Loop through each character (digit) in the string representation of the factorial
        for (char digit : factorialStr.toCharArray()) {
            // Add the numeric value of each digit to the sum
            sum += Character.getNumericValue(digit);
        }

        // Print the result: the sum of the digits of the factorial
        System.out.println("The sum of digits is: " + sum);
    }
}
