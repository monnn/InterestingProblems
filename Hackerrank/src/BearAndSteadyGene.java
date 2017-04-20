import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class BearAndSteadyGene {

    private static boolean isSteady(int n, Map<Character, Integer> map) {
        for (Integer count: map.values()) {
            if (count > n/4) {
                return false;
            }
        }
        return true;
    }

    private static int getMinOperations(int n, String string) {
        Map<Character, Integer> elements = new HashMap<>();
        elements.put('A', 0);
        elements.put('C', 0);
        elements.put('G', 0);
        elements.put('T', 0);

        string.chars()
                .mapToObj(el -> (char) el)
                .forEach(ch -> elements.put(ch, elements.get(ch) + 1));

        int min = string.length();
        int start = 0;
        int end = 0;

        while (start < string.length() && end < string.length()) {
            if (isSteady(n, elements)) {
                min = Math.min(min, end - start);
                elements.put(string.charAt(start), elements.get(string.charAt(start)) + 1);
                start++;
            } else {
                elements.put(string.charAt(end), elements.get(string.charAt(end)) - 1);
                end++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        System.out.println(getMinOperations(n, string));
    }
}
