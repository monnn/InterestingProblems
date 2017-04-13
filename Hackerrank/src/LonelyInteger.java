import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class LonelyInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        System.out.println(findLonelyInteger(elements));
    }

    private static int findLonelyInteger(Integer[] elements) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (temp.contains(elements[i])) {
                temp.remove(elements[i]);
            } else {
                temp.add(elements[i]);
            }
        }
        return temp.get(0);
    }
}
