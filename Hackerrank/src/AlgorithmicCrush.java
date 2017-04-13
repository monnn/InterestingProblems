import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class AlgorithmicCrush {

    private static List<Long> apply(List<Long> ints, List<String> operations) {
        for (String operation: operations) {
            ints = applyOperation(ints, operation);
        }
        return ints;
    }

    private static List<Long> applyOperation(List<Long> ints, String operation) {
        String[] op = operation.split(" ");
        int a = Integer.parseInt(op[0]);
        int b = Integer.parseInt(op[1]);
        long k = Long.parseLong(op[2]);
        if (a < 1 || a > b || a > ints.size() || b > ints.size() || k < 0 || k > Math.pow(10, 9)) {
            try {
                throw new Exception("1 <= a <= b <= N and 0 <= k <= 10^9");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        for (int i = a - 1; i < b; i++) {
            ints.set(i, ints.get(i) + k);
        }
        return ints;
    }

    private static boolean isValid(int n, int m) {
        if (n < 3 || n > (Math.pow(10, 7))) {
            try {
                throw new Exception("Numbers must be at least 3 and less than 10^7");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        if (m < 1 || m > 2*Math.pow(10, 5)) {
            try {
                throw new Exception("Operations must be at least 1 and less then 2*10^5");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<Long> ints = LongStream.generate(() -> 0)
                .limit(n)
                .boxed()
                .collect(Collectors.toList());

        List<String> operations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            operations.add(scanner.nextLine());
        }

        if (isValid(n, m)) {
            List<Long> result = apply(ints, operations);
            System.out.println(result.toString());
            System.out.println(Collections.max(result));
        }
    }
}
