package main.misc;

import java.util.Deque;
import java.util.List;
import java.util.Stack;

// test, if a given array holds a palindrome
public class Palindromes {

    public static void main(String[] args) {
        List<String> testStrings = List.of(
                "OTTO", "ANNA", "abc", "", "Hallo Welt", "lagerregal"
        );

        for(String test : testStrings) {
            System.out.printf("Check if '%s' is a palindrome: %b\n", test, checkPalindromePointer(test));
        }

        System.out.println("==============================");

        for(String test : testStrings) {
            System.out.printf("Check if '%s' is a palindrome: %b\n", test, checkPalindromeStack(test));
        }
    }

    public static boolean checkPalindromePointer(String text) {
        int i = 0;
        int j = text.length() - 1;

        while(i < text.length() / 2) {
            if(text.charAt(i) != text.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }

    public static boolean checkPalindromeStack(String test) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < test.length() / 2; i++) {
            stack.push(test.charAt(i));
        }

        for(int i = test.length() - stack.size(); i < test.length(); i++) {
            if(test.charAt(i) != stack.pop()) return false;
        }

        return true;
    }
}
