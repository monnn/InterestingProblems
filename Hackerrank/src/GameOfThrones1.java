import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class GameOfThrones1 {

    private static boolean canBePalindrome(String s) {

        Map<Character, Integer> map1 = new HashMap<>();
        s.chars().mapToObj(i -> (char)i).forEach(ch -> {
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        });
        boolean foundMiddle = false;
        for (Integer count : map1.values()) {
            if (count % 2 != 0 && foundMiddle) {
                return false;
            } else if (count % 2 != 0 && !foundMiddle ) {
                foundMiddle = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(canBePalindrome(scanner.nextLine()) ? "YES" : "NO");
    }
}
