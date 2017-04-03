import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MarkAndToys {

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

        System.out.println(getMaxNumberToys(prices, k));
    }

    private static int getMaxNumberToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int currentPrice = 0;
        int i = 0;
        int count = 0;
        while(i < prices.size() && currentPrice + prices.get(i) <= k) {
            currentPrice += prices.get(i);
            count++;
            i++;
        }
        return count;
    }
}
