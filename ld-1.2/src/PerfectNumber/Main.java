package PerfectNumber;

import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        PerfectNumber PerfectNumber = new PerfectNumber() {};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        try {
            int n = scanner.nextInt();
            System.out.println(PerfectNumber.detect(n));
        }
        catch (Exception e) {
            System.out.println("Please, enter an INTEGER between -2,147,483,648 to 2,147,483,647");
        }

        scanner.close();
    }
}
interface PerfectNumber {
    default String detect(int n) {
        return n > 0 ? parseAnswer(calculate(n), n) : "You must supply a natural number (POSITIVE integer)";
    }
    private int calculate(int n) {
        return IntStream
                .range(1, n)
                .filter(i -> n % i == 0)
                .sum();
    }
    private String parseAnswer(int sum, int n) {
        return sum < n ? "DEFICIENT" : sum > n ? "ABUNDANT": "PERFECT";
    }
}