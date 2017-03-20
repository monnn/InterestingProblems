import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class StringConstruction {

    private static int getCost(String s) {
        Set<Character> set = new HashSet<>();

        s.chars().mapToObj(i -> (char) i).forEach(set::add);
        return set.size();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(getCost(scanner.nextLine()));
        }
    }
}
