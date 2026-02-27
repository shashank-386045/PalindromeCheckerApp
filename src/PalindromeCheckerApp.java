// File: UseCase9PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        // Compare characters at start and end
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam";
        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}