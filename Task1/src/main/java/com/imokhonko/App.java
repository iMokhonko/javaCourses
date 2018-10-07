package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // sum of numbers
    private static int sumOfEvenNumbers = 0;
    private static int sumOfOddNumbers = 0;

    private static long F1; // biggest odd number
    private static long F2; // biggest even number

    // lists of evens and odds numbers from range
    private static List<Long> evens = new ArrayList<>();
    private static List<Long> odds = new ArrayList<>();
    private static List<Long> fibonacci = new ArrayList<>();

    public static void main(String[] args) {
        // range
        int startRange;
        int endRange;
        int fibonacciCount;

        Scanner scanner = new Scanner(System.in);

        // start number in the interval
        System.out.print("Enter the start number in the interval -> ");
        startRange = scanner.nextInt();

        // end number in the interval
        System.out.print("Enter the end number in the interval -> ");
        endRange = scanner.nextInt();

        // adding numbers to its lists
        for(int i = startRange; i <= endRange; i++) {
            if(i % 2 != 0) {
                odds.add((long) i); // add odd number to list of odd numbers
                sumOfOddNumbers += i; // increasing the sum of odd numbers
            } else {
                evens.add((long) i); // add even number to list of odd numbers
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

        // fibonacci set size
        System.out.print("Enter the size of fibonacci numbers set -> ");
        fibonacciCount = scanner.nextInt();

        /* adding fibonacci numbers to list */
        fibonacci.add((long) 0);
        fibonacci.add((long) 1);
        for(int i = 2; i < fibonacciCount; i++) fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));


        System.out.println("Fibonacci: " + fibonacci);

        // max fibonacci odd value
        F1 = getMaxFibonacciOddNumber(fibonacci);
        // max fibonacci even value
        F2 = getMaxFibonacciEvenNumber(fibonacci);

        System.out.println("Max odd number in fibonacci sequence: " + F1);
        System.out.println("Max even number in fibonacci sequence: " + F2);

        evens.clear();
        odds.clear();

        for(long number : fibonacci)
            if(number % 2 == 0)
                evens.add(number);
            else
                odds.add(number);

        System.out.println("Percentage of odd numbers: " + ((float)odds.size() / fibonacci.size() * 100) + "%");
        System.out.println("Percentage of even numbers: " + ((float)evens.size() / fibonacci.size() * 100) + "%");
    }

    /**
     * Calculates the max odd value in Fibonacci sequence
     * @param numbers list of Fibonacci numbers
     * @return max odd value in Fibonacci sequence
     */
    private static long getMaxFibonacciOddNumber(List<Long> numbers) {
        long result = 0;
        for(int i = numbers.size() - 1; i >= 0; i--)
            if(numbers.get(i) % 2 != 0) {
                result = numbers.get(i);
                break;
            }
        return result;
    }

    /**
     * Calculates the max even value in Fibonacci sequence
     * @param numbers list of Fibonacci numbers
     * @return max even value in Fibonacci sequence
     */
    private static long getMaxFibonacciEvenNumber(List<Long> numbers) {
        long result = 0;
        for(int i = numbers.size() - 1; i >= 0; i--) {
            if(numbers.get(i) % 2 == 0) {
                result = numbers.get(i);
                break;
            }
        }
        return result;
    }

}
