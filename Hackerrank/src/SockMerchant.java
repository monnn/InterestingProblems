import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SockMerchant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        Integer[] socks = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);

        int current;
        int sumOfPairs = 0;
        for (int i = 0; i < socks.length - 1; i++) {
            current = socks[i];

            for (int j = i + 1; j < socks.length; j++) {
                if (current == 0) {
                    break;
                }
                if (current == socks[j]) {
                    sumOfPairs++;
                    // 0 means empty slot
                    socks[j] = 0;
                    break;
                }
            }
        }
        System.out.println(sumOfPairs);
    }
}
