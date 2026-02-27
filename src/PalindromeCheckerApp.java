// File: UseCase10PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition
        if (start >= end) {
            return true;
        }
        // Compare characters at start and end
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive call with smaller substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string
        // Remove spaces and non-alphanumeric characters, convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Apply previous recursive logic
        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}