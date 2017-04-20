import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class InsertionSortPart2 {

    private static Integer[] sort(Integer[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int j = i;
                while (j > 0 && elements[j + 1] < elements[j]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    j--;
                    Arrays.stream(elements).forEach(element -> System.out.print(element + " "));
                    System.out.println();
                }
        }
        return elements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        Arrays.toString(sort(elements));
    }
}
