import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class PriyankaAndToys {

    private static int findMinimumUnits(List<Integer> weights) {
        Collections.sort(weights);
        int count = 0;
        int j;
        for (int i = 0; i < weights.size(); i++) {
            j = i;
            while (j < weights.size() - 1 && weights.get(j + 1) <= weights.get(i) + 4) {
                j++;
            }
            i = j;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> weights = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findMinimumUnits(weights));
    }
}
