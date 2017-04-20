import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Pairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        int n = params[0];
        int k = params[1];
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(countPairs(elements, k));
    }

    private static int countPairs(Integer[] elements, int k) {
        Arrays.sort(elements);
        int count = 0;
        int i = 0, j = 1;
        while ((j < elements.length)) {
            if (elements[j] - elements[i] == k) {
                count++;
                i++;
                j++;
            } else if (elements[j] - elements[i] < k) {
                if (j == elements.length - 1) {
                    return count;
                }
                j++;
            } else if (elements[j] - elements[i] > k) {
                i++;
            }
        }
        return count;
    }
}
