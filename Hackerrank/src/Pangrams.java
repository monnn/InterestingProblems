import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Pangrams {

    private static boolean isPangram(String s ) {
        String all = "abcdefghijklmnopqrstuvwxyz";
        String str = s.toLowerCase();
        for (int i = 0; i < all.length(); i++) {
            if (str.indexOf(all.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isPangram(s) ? "pangram" : "not pangram");
    }
}
