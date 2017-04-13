import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class AlgorithmicCrushGoodMemory {

    private static final long MAX_K = (long) Math.pow(10, 9);

    private static List<Interval> apply(long n, List<Interval> ints, List<String> operations) {
        for (String operation: operations) {
            long start = System.currentTimeMillis();
            ints = applyOperation(n, ints, operation);
            System.out.println(System.currentTimeMillis() - start);
        }
        return ints;
    }

    private static List<Interval> applyOperation(long n, List<Interval> ints, String operation) {
        String[] op = operation.split(" ");
        long a = Long.parseLong(op[0]);
        long b = Long.parseLong(op[1]);
        long k = Long.parseLong(op[2]);
        if (a < 1 || a > b || a > n || b > n || k < 0 || k > MAX_K) {
            try {
                throw new Exception("1 <= a <= b <= N and 0 <= k <= 10^9");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }

        return operate(ints, a, b, k);
    }

    private static List<Interval> operate(List<Interval> ints, long a, long b, long k) {
        Interval current;
        int size = ints.size();
        for (int i = 0; i < size; i++) {
            current = ints.get(i);
            if (a > current.lower && a <= current.upper) {
                //lower bound is in this interval;
                if (b >= current.upper) {
                    //upper bound is outside this interval;
                    ints.add(new Interval(a, current.upper, current.value + k));
                } else {
                    //upper bound is in this interval;
                    ints.add(new Interval(a, b, current.value + k));
                    ints.add(new Interval(b + 1, current.upper, current.value));
                }
                current.upper = a - 1;
            }

            if (a <= current.lower && b >= current.lower) {
                if (b >= current.upper) {
                    current.value += k;
                } else {
                    ints.add(new Interval(current.lower, b, current.value + k));
                    current.lower = b + 1;
                }
            }
        }
        return ints;
    }

    static class Interval {
        long lower;
        long upper;
        long value;

        public Interval(long lower, long upper, long value) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        long n = Long.parseLong(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Interval> ints = new ArrayList<>();
        ints.add(new Interval(0, n, 0));

        List<String> operations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            operations.add(scanner.nextLine());
        }

        if (isValid(n, m)) {
            List<Interval> result = apply(n, ints, operations);
            long max = 0;
            for (Interval interval : result) {
                if (interval.value > max) {
                    max = interval.value;
                }
            }
            System.out.println(result.size());
            System.out.println(max);
        }
    }
}
