import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class LargestPermutation {

    private static List<Integer> getMaxPermutation(List<Integer> elements, int k) {
        int currentMaxIndex;
        int swapsCount = 0;
        for (int i = 0; swapsCount < k && i < elements.size(); i++) {
            currentMaxIndex = getIndexOfMax(elements, i);
            if (elements.get(currentMaxIndex) > elements.get(i)) {
                swap(elements, i, currentMaxIndex);
                swapsCount++;
            }
        }
        return elements;
    }

    private static int getIndexOfMax(List<Integer> elements, int startIndex) {
        int maxIndex = startIndex;
        for (int i = startIndex; i < elements.size(); i++) {
            if (elements.get(i) > elements.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .toArray(Integer[]::new);
        int n = params[0];
        int k = params[1];

        List<Integer> elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        List<Integer> largestPermutation = (getMaxPermutation(elements, k));
        largestPermutation.stream().forEach(el -> System.out.print(el + " "));
    }
}
