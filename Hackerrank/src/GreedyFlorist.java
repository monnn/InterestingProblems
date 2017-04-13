import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class GreedyFlorist {

    private static int getMinimumCost(List<Integer> prices, int n, int k) {
        int currentPrice = 0;
        Collections.sort(prices);

        int mul = 0;
        while(!prices.isEmpty()) {
            for (int i = n - 1; i >= n - k && i >= 0; i--) {
                currentPrice += prices.get(i) * (mul + 1);
                prices.remove(i);
            }
            mul+=1;
            n = prices.size();
        }

        return currentPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .toArray(Integer[]::new);
        int n = params[0];
        int k = params[1];

        List<Integer> prices = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        System.out.println(getMinimumCost(prices, n ,k));
    }
}
