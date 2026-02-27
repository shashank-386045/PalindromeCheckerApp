import java.util.*;
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
    String getName();
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

    @Override
    public String getName() {
        return "StackStrategy";
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
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

    @Override
    public String getName() {
        return "DequeStrategy";
    }
}
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
    @Override
    public String getName() {
        return "RecursiveStrategy";
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        );
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean result = strategy.checkPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(strategy.getName() + ": " +
                    (result ? "Palindrome" : "Not Palindrome") +
                    " | Execution Time = " + duration + " ns");
        }
    }
}