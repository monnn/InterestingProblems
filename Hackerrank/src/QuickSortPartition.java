import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class QuickSortPartition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        printArray(partition(elements));
    }

    private static int[] partition(Integer[] elements) {
        int pivot = elements[0];
        int[] smaller = new int[elements.length];
        int[] equal = new int[elements.length];
        int[] larger = new int[elements.length];
        int[] result = new int[elements.length];
        int k = 0, j = 0, l = 0;
        for (Integer element: elements) {
            if (element < pivot) {
                smaller[k++] = element;
            } else if (element > pivot) {
                larger[j++] = element;
            } else {
                equal[l++] = element;
            }
        }
        System.arraycopy(smaller, 0, result, 0, k);
        System.arraycopy(equal, 0, result, k, l);
        System.arraycopy(larger, 0, result, k + l, j);
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
