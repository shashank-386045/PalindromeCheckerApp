
class PalindromeChecker {


    public boolean checkPalindrome(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        return isPalindrome(normalized, 0, normalized.length() - 1);
    }


    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1); // Recursive call
    }
}


public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        String input = "A man a plan a canal Panama";
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}