package PerfectNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PerfectNumber PerfectNumber = new PerfectNumber() {};
        Scanner scanner = new Scanner(System.in);
        int n;
        String s;
        while (true) {
            System.out.print("Enter a positive integer (or enter 0 to exit): ");
            try {
                s = scanner.nextLine();
                n = Integer.parseInt(s);
                if (n == 0)
                    break;
                else System.out.println(PerfectNumber.detect(n));
            } catch (Exception e) {
                System.out.println("Please, enter an INTEGER between -2,147,483,648 to 2,147,483,647");
            }
        }
        scanner.close();
    }
}

interface PerfectNumber {
    default String detect(int n) {
        if (n <= 0) return "You must supply a natural number (POSITIVE integer)";

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