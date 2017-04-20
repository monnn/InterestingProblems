import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class CountingSort3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int index = 0;
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[index++] = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        }
        printArray(sort(elements));
    }

    private static int[] sort(int[] elements) {
        int[] result = new int[100];
        for (int i = 0; i < elements.length; i++) {
            result[elements[i]]++;
        }
        return result;
    }

    private static void printArray(int[] array) {
        for (int i = 1; i <= array.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += array[j];
            }
            System.out.print(sum + " ");
        }
    }
}
