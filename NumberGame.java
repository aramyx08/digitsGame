import java.util.Scanner;
import java.util.Random;
//hello

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Generate 6 random numbers between 1 and 20
        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 20) + 1;
        }

\
        int goalNumber = (int)(Math.random(0,6));

        System.out.println("Welcome to the Number Game!");
        System.out.println("Your goal is to reach " + goalNumber + " using the following numbers:");

        // Print the 6 random numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Enter an operation (+, -, *, /) and two numbers to perform the operation (e.g. + 2 3):");
            String operation = input.next();
            int num1 = input.nextInt();
            int num2 = input.nextInt();

            int result = 0;
            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            } else if (operation.equals("*")) {
                result = num1 * num2;
            } else if (operation.equals("/")) {
                result = num1 / num2;
            } else {
                System.out.println("Invalid operation!");
                continue;
            }

            // Check if the result is one of the 6 numbers
            boolean validResult = false;
            for (int i = 0; i < numbers.length; i++) {
                if (result == numbers[i]) {
                    validResult = true;
                    numbers[i] = result; // Replace the used number with the result
                    break;
                }
            }

            if (validResult) {
                System.out.println("Valid operation! Your new numbers are:");
                for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i] + " ");
                }
                System.out.println();

                // Check if the user reached the goal number
                if (result == goalNumber) {
                    System.out.println("Congratulations! You reached the goal number!");
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid operation! The result is not one of the numbers.");
            }
        }

        System.out.println("Thanks for playing!");
    }
}
