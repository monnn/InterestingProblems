import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TheHurdleRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        int max = 0;
        for (Integer element: elements) {
            if (element > max) {
                max = element;
            }
        }
        if (max < k) {
            System.out.println(0);
        } else {
            System.out.println(max - k);
        }
    }
}
