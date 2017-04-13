import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SherlockAndArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> elements = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println(findSpecial(elements) ? "YES" : "NO");
        }
    }

    private static boolean findSpecial(List<Integer> elements) {
        int left = 0;
        int right = sum(elements) - elements.get(0);
        if (right == 0) {
            return true;
        }
        for (int i = 1; i < elements.size(); i++) {
            left += elements.get(i - 1);
            right -= elements.get(i);
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    private static int sum(List<Integer> elements) {
        return elements.stream().reduce(0, (x, y) -> x + y);
    }
}
