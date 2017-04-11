import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int n;
        int m;
        int[] res;
        for (int i = 0; i < t; i++) {
            m = Integer.parseInt(scanner.nextLine());
            n = Integer.parseInt(scanner.nextLine());
            List<Integer> prices = Arrays.stream(scanner.nextLine().split(" "))
                    .map(price -> Integer.parseInt(price)).collect(Collectors.toList());

            res = getIceCreamIds(m, prices);
            System.out.println((res[0] + 1) + " " + (res[1] + 1));
        }
    }

    private static int[] getIceCreamIds(int m, List<Integer> prices) {
        int[] res = new int[2];
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < m) {
                for (int j = 1; j < prices.size(); j++) {
                    if (i != j && prices.get(i) + prices.get(j) == m) {
                        res[0] = i < j ? i : j;
                        res[1] = i < j ? j : i;
                    }
                }
            }
        }
        return res;
    }
}
