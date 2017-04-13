import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class AlgorithmicCrushBetterMemory {

    private static final long MAX_K = (long) Math.pow(10, 9);

    private static Interval parseOperation(String operation, long n) {
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

        return new Interval(a, b, k);
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

        Interval[] operations = new Interval[m];
        for (int i = 0; i < m; i++) {
            operations[i] = parseOperation(scanner.nextLine(), n);
        }

        if (isValid(n, m)) {
            long start = System.currentTimeMillis();
            Set<Long> lowerBounds = new HashSet<>();
            int i = m;
            while (--i >= 0) {
                Interval op = operations[i];
                lowerBounds.add(op.lower);
                lowerBounds.add(op.upper + 1);
            }
            Arrays.sort(operations, (op1, op2) -> op1.lower > op2.lower ? -1 : (op1.lower < op2.lower ? 1 : 0));
            long max = 0;
            for (long bound : lowerBounds) {
                long sum = 0;
                i = m;
                while (--i >= 0) {
                    Interval op = operations[i];
                    if (bound < op.lower) {
                        break;
                    }
                    if (bound <= op.upper) {
                        sum += op.value;
                    }
                }

                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println(System.currentTimeMillis() - start);
            System.out.println(max);
        }
    }
}
