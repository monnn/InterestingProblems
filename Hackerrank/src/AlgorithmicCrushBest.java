import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class AlgorithmicCrushBest {

    private static final long MAX_K = (long) Math.pow(10, 9);

    private static Interval parseOperation(String operation, long n) {
        String[] op = operation.split(" ");
        int a = Integer.parseInt(op[0]);
        int b = Integer.parseInt(op[1]);

        int k = Integer.parseInt(op[2]);
        if (a < 1 || a > b || a > n || b > n || k < 0 || k > MAX_K) {
            try {
                throw new Exception("1 <= a <= b <= N and 0 <= k <= 10^9");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }

        return new Interval(a, b, k);
    }

    static class Interval {
        int lower;
        int upper;
        int value;

        public Interval(int lower, int upper, int value) {
            this.lower = lower;
            this.upper = upper;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "lower=" + lower +
                    ", upper=" + upper +
                    ", value=" + value +
                    '}';
        }
    }

    private static boolean isValid(long n, int m) {
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

    private static long crush(int n, int m, long[] numbers, Interval[] operations) {

        for(int i = 0; i < m; i++) {
            numbers[operations[i].lower-1] += operations[i].value;
            numbers[operations[i].upper] -= operations[i].value;
        }

        long max = numbers[0];
        long sum = max;
        for(int i = 1; i < n; i++) {
            sum += numbers[i];
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Interval[] operations = new Interval[m];
        for (int i = 0; i < m; i++) {
            operations[i] = parseOperation(scanner.nextLine(), n);
        }

        long[] numbers = new long[n + 1];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
        }

        if (isValid(n, m)) {
            long max = crush(n, m, numbers, operations);
            System.out.println(max);
        }
    }
}

