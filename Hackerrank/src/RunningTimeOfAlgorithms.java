import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class RunningTimeOfAlgorithms {

    private static int sort(Integer[] elements) {
        int count = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            int j = i;
            while (j >= 0 && elements[j + 1] < elements[j]) {
                int temp = elements[j];
                elements[j] = elements[j + 1];
                elements[j + 1] = temp;
                j--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        System.out.println((sort(elements)));
    }
}
