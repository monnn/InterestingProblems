import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class QuickSortSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        quicksort(elements, 0, elements.length - 1);
    }

    private static void quicksort(int[] elements, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition(elements, start, end);

        //recursively partition each part
        quicksort(elements, start, j - 1);
        quicksort(elements, j + 1, end);
        for (int k = start; k <= end; k++) {
            System.out.print(elements[k] + " ");
        }
        System.out.println();
    }

    //returns the position of pivot after partitioning
    private static int partition(int[] elements, int start, int end) {
        int pivot = elements[start];
        int[] smaller = new int[elements.length];
        int[] equal = new int[elements.length];
        int[] larger = new int[elements.length];
        int element;
        int k = 0, j = 0, l = 0;

        for (int i = start; i <= end; i++) {
            element = elements[i];
            if (element < pivot) {
                smaller[k++] = element;
            } else if (element > pivot) {
                larger[j++] = element;
            } else {
                equal[l++] = element;
            }
        }

        System.arraycopy(smaller, 0, elements, start, k);
        System.arraycopy(equal, 0, elements, start + k, l);
        System.arraycopy(larger, 0, elements, start + k + l, j);

        return start + k;
    }
}
