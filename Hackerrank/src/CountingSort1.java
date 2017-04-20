import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class CountingSort1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        printArray(count(elements));
    }

    private static int[] count(int[] elements) {
        int[] result = new int[100];
        for (int i = 0; i < elements.length; i++) {
            result[elements[i]]++;
        }
        return result;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length) {
                System.out.print(" ");
            }
        }
    }
}
