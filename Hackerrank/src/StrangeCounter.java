import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class StrangeCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        System.out.println(getValue(n));
    }

    private static long getValue(long t) {
        int n = 0;
        while ((t + 2)/3 >= Math.pow(2, n))  {
            n++;
        }

//        while ((t + 2) / 3 >> n > 0)  {
//            n++;
//        }

        long upper = (long) (3*Math.pow(2, n) - 2);
//        long upper = ((3L << n) - 2);
        return upper - t;
    }
}
