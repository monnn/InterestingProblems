import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class PalindromeIndex {

    private static int getPalindromeIndex(String s) {
        if (isPalindrome(s)) {
            return -1;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                //check if char at s.length() - i - 1 has to be removed
                if (s.charAt(i) == s.charAt(s.length() - i - 2)) {
                    if (isPalindrome(new String(s.substring(0, s.length() - i - 1 ) + s.substring(s.length() - i)))) {
                        return s.length() - i - 1;
                    }
                }
                //check for char at i
                if (s.charAt(i + 1) == s.charAt(s.length() - i - 1)) {
                    if (isPalindrome(new String(s.substring(0, i ) + s.substring(i + 1)))) {
                        return i;
                    }
                }
            }
        }

        return 0;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(getPalindromeIndex(scanner.nextLine()));
        }
    }
}
