import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SimpleArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        Integer sum = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .reduce(0, (Integer acc, Integer val) -> acc + val);

        System.out.println(sum);

        Long bigSum = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Long.parseLong(number))
                .reduce(new Long(0), (Long acc, Long val) -> acc + val);

        System.out.println(bigSum);
    }
}
