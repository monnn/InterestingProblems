import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class HackerrankInAString {

    private static boolean contains (String s) {
        String hackerrank = "hackerrank";
        int count = 0;
        int prevIndex = 0;
        for (int i = 0; i < hackerrank.length(); i++) {
            for (int j = prevIndex; j < s.length(); j++) {
                if (hackerrank.charAt(i) == s.charAt(j)) {
                    count++;
                    prevIndex = j + 1;
                    break;
                }
            }
        }
        return count == hackerrank.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            System.out.println(contains(scanner.nextLine()) ? "YES" : "NO");
        }
    }
}
