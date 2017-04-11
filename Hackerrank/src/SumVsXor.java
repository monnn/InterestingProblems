import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SumVsXor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        int count = 0;

        while(n > 0) {
            if((n & 0x1) == 0) {
                count++;
            }
            n >>= 1;
        }
        System.out.println(1L << count);
    }
}
