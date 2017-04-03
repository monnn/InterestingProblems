import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class CavityMap {

    private static void detectCavities(char[][] array, int n) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (Character.getNumericValue(array[i][j]) > Character.getNumericValue(array[i - 1][j]) &&
                        Character.getNumericValue(array[i][j]) > Character.getNumericValue(array[i][j - 1]) &&
                        Character.getNumericValue(array[i][j]) > Character.getNumericValue(array[i + 1][j]) &&
                        Character.getNumericValue(array[i][j]) > Character.getNumericValue(array[i][j + 1])) {
                    array[i][j] = 'X';
                }
            }
        }
    }

    private static void print(char[][] ints, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = row.charAt(j);
            }
        }
        detectCavities(array, n);
        print(array, n);
    }
}
