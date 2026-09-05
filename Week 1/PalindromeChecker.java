import java.util.*;

public class PalindromeChecker {

    // 1. Iterative approach
    static boolean isPalindromeIterative(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    // 2. Recursive approach
    static boolean isPalindromeRecursive(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return isPalindromeRecursive(s.substring(1, s.length() - 1));
    }

    // 3. Array reversal approach
    static boolean isPalindromeArrayReversal(String s) {
        char[] a = s.toCharArray();

        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return s.equals(new String(a));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " +
            (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
            (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
            (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}