import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SherlockAndTheBeast {

    private static StringBuilder stringBuilder;

    private static String getMaxNumber(int n) {
        stringBuilder = new StringBuilder();

        if (n < 3 || n == 4 || n == 7) {
            return "-1";
        } else if (n % 3 == 0) {
            for (int i = 0; i < n; i++) {
                stringBuilder.append(5);
            }
            return stringBuilder.toString();
        } else if (n % 3 == 1) {
            for (int i = 0; i < n - 10; i++) {
                stringBuilder.append(5);
            }
            for (int i = 0; i < 10; i++) {
                stringBuilder.append(3);
            }
            return stringBuilder.toString();
        } else if (n % 3 == 2) {
            for (int i = 0; i < n - 5; i++) {
                stringBuilder.append(5);
            }
            for (int i = 0; i < 5; i++) {
                stringBuilder.append(3);
            }
            return stringBuilder.toString();
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(getMaxNumber(Integer.parseInt(scanner.nextLine())));
        }
    }
}
