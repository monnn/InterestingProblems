import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class FlippingBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            BigInteger big = BigInteger.valueOf(Long.parseLong(scanner.nextLine()));
            for (int j = 0; j < 32; j++) {
                big = big.flipBit(j);
            }
            System.out.println(big);
        }
    }
}
