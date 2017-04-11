import java.math.BigInteger;
import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class FibonacciModified {

    private static int t1;
    private static int t2;
    private static Map<Integer, BigInteger> computed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        computed = new HashMap<>();
        Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                .map(param -> Integer.parseInt(param))
                .toArray(Integer[]::new);

        t1 = params[0];
        t2 = params[1];
        int n = params[2];

        System.out.println(fib(n));

    }

    private static BigInteger fib(int n) {
        if (computed.containsKey(n)) {
            return computed.get(n);
        }

        if (n == 1) {
            return BigInteger.valueOf(t1);
        }
        if (n == 2) {
            return BigInteger.valueOf(t2);
        }

        BigInteger result = fib(n - 2).add(fib(n - 1).pow(2));
        computed.put(n, result);
        return result;
    }
}
