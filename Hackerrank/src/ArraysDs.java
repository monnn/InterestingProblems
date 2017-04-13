import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class ArraysDs {

    private static boolean isValid(int length, Integer[] numbers) {

        if (length > (Math.pow(10, 3))) {
            try {
                throw new Exception("Length must be less than 10^3");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        if (numbers.length != length) {
            try {
                throw new Exception("Elements must be same length n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        Arrays.stream(numbers).forEach(number -> {
            if (number > Math.pow(10, 4)) {
                try {
                    throw new Exception("Each element must be less than 10^4");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = new Integer(scanner.nextLine());
        String[] numbers = scanner.nextLine().split(" ");
        Integer[] ints = Arrays.stream(numbers).map(number -> Integer.parseInt(number)).toArray(Integer[]::new);

        if (isValid(length, ints)) {
            List<Integer> list = Arrays.asList(ints);
            Collections.reverse(list);
            list.stream().forEach(element -> System.out.print(element + " "));
        }
    }
}
