import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Anagram {

    private static int countChanges(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }

        int count = 0;
        String first = s.substring(0, s.length()/2);
        String second = s.substring(s.length()/2, s.length());

        Map<Character, Integer> map1 = new HashMap<>();
        first.chars().mapToObj(i -> (char)i).forEach(ch -> {
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        });

        Map<Character, Integer> map2 = new HashMap<>();
        second.chars().mapToObj(i -> (char)i).forEach(ch -> {
            if (map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        });

        for (Map.Entry entry1 : map1.entrySet()) {
            if (map2.get(entry1.getKey()) != null && (Integer) entry1.getValue() > map2.get(entry1.getKey())) {
                count += (Integer) entry1.getValue() - map2.get(entry1.getKey());
                } else if (map2.get(entry1.getKey()) == null) {
                count += (Integer) entry1.getValue();
            }
        }

        System.out.println(first);
        System.out.println(second);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(countChanges(scanner.nextLine()));
        }
    }
}
