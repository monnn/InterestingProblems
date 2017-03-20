import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class EqualizeTheArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);
        Arrays.sort(numbers);
//        Arrays.stream(numbers).forEach(System.out::print);

        //find the count of most common
        //return array length - count of most common
        int max = 0;
        int currentMax = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }
        System.out.println(n - max);
    }
}
