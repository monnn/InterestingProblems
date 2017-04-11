import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MaximizingXOR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());
        int r = Integer.parseInt(scanner.nextLine());
        System.out.println(findMaximumXOR(l, r));
    }

    private static int findMaximumXOR(int l, int r) {
        int max = 0;
        for (int i = l; i <= r; i++) {
            for (int j = l; j <= r; j++) {
                if ((i ^ j) > max) {
                    max = i ^ j;
                }
            }
        }
        return max;
    }
}
