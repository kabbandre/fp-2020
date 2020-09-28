package PerfectNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Enter a positive integer: ");
            n = scanner.nextInt();
            if (n == 0)
                break;
            else System.out.println(PerfectNumber.detect(n));
        }
    }
}

class PerfectNumber {
    public static String detect(int n) {
        if (n <= 0) return "You must supply a natural number (positive integer)";

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }

        if (sum == 1 || sum < n) return "Deficient";
        else if (sum > n) return "Abundant";
        else return "Perfect";
    }
}