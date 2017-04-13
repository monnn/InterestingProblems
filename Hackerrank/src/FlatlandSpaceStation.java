import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class FlatlandSpaceStation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] params = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int n = params[0];
        int m = params[1];
        List<Integer> stationIndexes = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(getMaximumDistance(n, m, stationIndexes));
    }

    private static int getMaximumDistance(int n, int m, List<Integer> stationIndexes) {
        Collections.sort(stationIndexes);
        int max = 0;
        int currentDifference;
        for (int i = 0; i < stationIndexes.size() - 1; i++) {
            currentDifference = (int) Math.ceil((stationIndexes.get(i + 1) - stationIndexes.get(i)) / 2);
            if (currentDifference > max) {
                max = currentDifference;
            }
        }
        if (stationIndexes.get(0) > max) {
            max = stationIndexes.get(0);
        }
        if ((n - 1) - stationIndexes.get(stationIndexes.size() - 1) > max) {
            max = (n - 1) - stationIndexes.get(stationIndexes.size() - 1);
        }
        return max;
    }
}
