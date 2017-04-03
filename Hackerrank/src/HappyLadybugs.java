import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class HappyLadybugs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < g; i++) {
            System.out.println(canLadybugsBeHappy(Integer.parseInt(scanner.nextLine()), scanner.nextLine()) ? "YES" : "NO");
        }
    }

    private static boolean canLadybugsBeHappy(int i, String board) {
        List<Character> list = new ArrayList<>();

        board.chars().mapToObj(el -> (char) el).forEach(ch -> {
            if (ch != '_') {
                list.add(ch);
            }
        });

        if (list.size() == 1) {
            return false;
        }

        if (board.indexOf('_') == -1) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) != list.get(j - 1) && (j + 1 >= list.size() || list.get(j) != list.get(j + 1))) {
                    return false;
                }
            }
            return true;
        }

        for (Character ch : list) {
            if (Collections.frequency(list, ch) < 2) {
                return false;
            }
        }
        return true;
    }
}
