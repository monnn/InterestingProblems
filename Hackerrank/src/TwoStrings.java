import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TwoStrings {

    private static boolean checkSubstring(String a, String b) {
        Set<Character> set1 = new HashSet<>();
        a.chars().mapToObj(i -> (char)i).forEach(set1::add);

        Set<Character> set2 = new HashSet<>();
        b.chars().mapToObj(i -> (char)i).forEach(set2::add);

        for (Character ch1: set1) {
            for (Character ch2: set2) {
                if (ch1 == ch2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String a;
        String b;
        for (int i = 0; i < n; i++) {
            a = scanner.nextLine();
            b = scanner.nextLine();
            System.out.println(checkSubstring(a, b) ? "YES" : "NO");
        }
    }
}
