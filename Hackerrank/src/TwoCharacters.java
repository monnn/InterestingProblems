import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TwoCharacters {

    private static List<Character> sArray;

    private static int validateT(char first, char second) {
        int stack = 0;
        int result = 0;
        for (Character ch: sArray) {
            if (ch == first) {
                stack++;
                if (stack > 1) {
                    return 0;
                }
                result++;
            } else if (ch == second) {
                stack --;
                if (stack < 0) {
                    return 0;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        String s = scanner.nextLine();
        sArray = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        List<Character> unique = new ArrayList<>();
        for (Character ch: sArray) {
            if (!unique.contains(ch)) {
                unique.add(ch);
            }
        }
        int max = 0;
        int current;
        for (int i = 0; i < unique.size(); i++) {
            for (int j = 1; j < unique.size(); j++) {
                current = validateT(unique.get(i), unique.get(j));
                if (current > max) {
                    System.out.println(current + " for " + unique.get(i) + " and " + unique.get(j));
                    max = current;
                }
            }
        }
        System.out.println(max);
    }
}
