import java.util.Scanner;

import static java.lang.Character.isUpperCase;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class CamelCase {

    private static boolean isValid(String s) {
        if (s.length() > (Math.pow(10, 5))) {
            try {
                throw new Exception("Length must be less than 10^5");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (isValid(s)) {
            int sum = 1;
            for (int i = 0; i < s.length(); i++) {
                if (isUpperCase(s.charAt(i))) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
