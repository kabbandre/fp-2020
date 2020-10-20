package Palidrome;

import java.util.Scanner;

public class Main {
    static boolean palindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return palindrome(s.substring(1, s.length()-1));
        return false;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        if (palindrome(s.toLowerCase()))
            System.out.println("String is a palindrome");
        else
            System.out.println("String is NOT a palindrome");

        scanner.close();
    }
}
