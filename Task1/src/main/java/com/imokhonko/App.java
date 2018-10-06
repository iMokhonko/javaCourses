package com.imokhonko;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    // range
    private static int startNumber;
    private static int endNumber;

    // sum of numbers
    private static int sumOfEvenNumbers = 0;
    private static int sumOfOddNumbers = 0;

    private static int F1; // biggest odd number
    private static int F2; // biggest even number

    // lists of evens and odds numbers from range
    private static List<Integer> evens = new ArrayList<>();
    private static List<Integer> odds = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // start number
        System.out.print("Enter the start number -> ");
        startNumber = scanner.nextInt();

        // end number
        System.out.print("Enter the end number -> ");
        endNumber = scanner.nextInt();

        // adding numbers to its lists
        for(int i = startNumber; i <= endNumber; i++) {
            if(i % 2 != 0) {
                odds.add(i); // add odd number to list of odd numbers
                sumOfOddNumbers += i; // increasing the sum of odd numbers
            } else {
                evens.add(i); // add even number to list of odd numbers
                sumOfEvenNumbers += i; // increasing the sum of even numbers
            }
        }

        // print odds numbers
        System.out.print("Odds: ");
        odds.forEach((number) -> System.out.print(number + " "));

        // print even numbers in reverse order
        System.out.print("\nEvens: ");
        for(int i = evens.size() - 1; i >= 0; i--) {
            System.out.print(evens.get(i) + " ");
        }

        System.out.println("\nSum of odd numbers = " + sumOfOddNumbers);
        System.out.println("Sum of even numbers = " + sumOfEvenNumbers);

        System.out.print("Even fibonacci: ");
        printFibonacci(evens);
        System.out.print("\nOdd fibonacci: ");
        printFibonacci(odds);

        // max fibonacci values
        F1 = maxFibonacciNumber(odds);
        F2 = maxFibonacciNumber(evens);

        System.out.println("\nBiggest odd number in fibonacci = " + F1);
        System.out.println("Biggest even number in fibonacci = " +F2);

        int allNumbersCount = odds.size() + evens.size();

        System.out.println("Percentage of odd numbers: " +  (( (float) odds.size() / allNumbersCount) * 100) + "%");
        System.out.println("Percentage of even numbers: " +  (( (float) evens.size() / allNumbersCount) * 100) + "%");
    }

    /**
     * Calculates the max value in Fibonacci list
     * @param numbers - list of Fibonacco numbers
     * @return max value in Fibonacci
     */
    private static int maxFibonacciNumber(List<Integer> numbers) {
        numbers.sort((o1, o2) -> o1 - o2); // sort this list if numbers are not in natural order
        return numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
    }

    /**
     * Prints Fibonacci numbers from list.
     * @param numbers - list of Integer numbers
     */
    private static void printFibonacci(List<Integer> numbers) {
        int first = numbers.get(0);
        int second = numbers.get(1);
        System.out.print(first + " " + second + " ");

        for(int i = 2; i <= numbers.size(); i++) {
            int curretFibNumber = numbers.get(i - 2) + numbers.get(i - 1);
            System.out.print(curretFibNumber + " ");
        }
    }


}
