

public class PalindromeCheckerApp {


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
        String input = "A man a plan a canal Panama";


        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("\"" + input + "\" is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}