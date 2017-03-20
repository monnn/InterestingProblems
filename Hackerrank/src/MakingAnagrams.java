import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MakingAnagrams {

    private static int countChanges(String first, String second) {
        int count = 0;

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

        for (Map.Entry entry2 : map2.entrySet()) {
            if (map1.get(entry2.getKey()) != null && (Integer) entry2.getValue() > map1.get(entry2.getKey())) {
                count += (Integer) entry2.getValue() - map1.get(entry2.getKey());
            } else if (map1.get(entry2.getKey()) == null) {
                count += (Integer) entry2.getValue();
            }
        }

        System.out.println(first);
        System.out.println(second);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countChanges(scanner.nextLine(), scanner.nextLine()));
    }
}

