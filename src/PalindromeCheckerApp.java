

import java.util.*;


interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}


class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return normalized.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        // Normalize string
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        PalindromeStrategy strategy;
        if (args.length > 0 && args[0].equalsIgnoreCase("stack")) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }
        boolean result = strategy.checkPalindrome(input);
        if (result) {
            System.out.println("\"" + input + "\" is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}