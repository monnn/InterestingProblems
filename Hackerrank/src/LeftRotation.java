import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class LeftRotation {

    // when rotating just take m elements from beginning and put them in the end
    private static List<Integer> rotateLeft(List<Integer> numbers, int m) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            temp.add(numbers.get(i));
        }
        numbers.addAll(temp);
        return numbers.subList(temp.size(), numbers.size());
    }

    private static boolean isValid(List<Integer> numbers, int n, int m) {
        if (n < 1 || n > (Math.pow(10, 5)) || m < 1 || m > n) {
            try {
                throw new Exception("Length must be less than 10^5 and m must me less than n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        if (numbers.size() != n) {
            try {
                throw new Exception("Elements must be same length as n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        numbers.stream().forEach(number -> {
            if (number < 1 || number > Math.pow(10, 6)) {
                try {
                    throw new Exception("Each element must be less than 10^6");
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
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] numbersString = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(numbersString).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
//        List<Integer> numbers = IntStream
//                .iterate(1, i -> i + 1)
//                .limit(n)
//                .boxed()
//                .collect(Collectors.toList());

        if (isValid(numbers, n, m)) {
            numbers = rotateLeft(numbers, m);
        }

        numbers.stream().forEach(number -> System.out.print(number + " "));
    }
}
