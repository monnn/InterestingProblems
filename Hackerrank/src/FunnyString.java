import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class FunnyString {

    private static boolean isFunny(String s) {
        String reversed = new StringBuffer(s).reverse().toString();
        for (int i = 1; i < s.length() ; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(reversed.charAt(i) - reversed.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(isFunny(scanner.nextLine()) ? "Funny" : "Not Funny");
        }
    }
}
