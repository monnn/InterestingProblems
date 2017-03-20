import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Gemstones {

    private static int countGems(List<String> list) {
        List<Character> firstString = new ArrayList<>();
        list.get(0).chars().mapToObj(i -> (char) i).forEach(firstString::add);
        List<Character> repeaters = getCommonChars(firstString, list.get(1));

        for (int i = 2; i < list.size(); i++) {
            repeaters = getCommonChars(repeaters, list.get(i));
        }

        System.out.println(repeaters.toString());
        return repeaters.size();
    }

    private static List<Character> getCommonChars(List<Character> first, String second) {
        List<Character> list1 = new ArrayList<>();
        for (Character ch : first) {
            if (!list1.contains(ch)) {
                list1.add(ch);
            }
        }
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < second.length(); i++) {
            if (!list2.contains(second.charAt(i))) {
                list2.add(second.charAt(i));
            }
        }

        List<Character> repeater = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {
                    repeater.add(list1.get(i));
                }
            }
        }
        return repeater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        System.out.println(countGems(list));
    }
}
