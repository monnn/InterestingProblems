import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TheGridSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] arrayParams;
        int arrayColumns;
        int arrayRows;
        Integer[] patternParams;
        int patternColumns;
        int patternRows;
        for (int k = 0; k < n; k++) {
            arrayParams = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            arrayRows = arrayParams[0];
            arrayColumns = arrayParams[1];
            char[][] array = new char[arrayRows][arrayColumns];
            for (int i = 0; i < arrayRows; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < arrayColumns; j++) {
                    array[i][j] = row.charAt(j);
                }
            }

            patternParams = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            patternRows = patternParams[0];
            patternColumns = patternParams[1];
            char[][] pattern = new char[patternRows][patternColumns];
            for (int i = 0; i < patternRows; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < patternColumns; j++) {
                    pattern[i][j] = row.charAt(j);
                }
            }
            System.out.println(canFindPattern(array, arrayColumns, arrayRows, pattern, patternColumns, patternRows) ? "YES" : "NO");
        }
    }

    private static boolean canFindPattern(char[][] array, int arrayColumns, int arrayRows, char[][] pattern, int patternColumns, int patternRows) {
        int c = 0;
        int r = 0;
        for (int i = 0; i <= arrayRows - patternRows; i++) {
            for (int j = 0; j <= arrayColumns - patternColumns; j++) {
                while (array[i + r][j + c] == pattern[r][c]) {
                    if (r == patternRows - 1 && c == patternColumns - 1) {
                        return true;
                    }

                    if (c < patternColumns - 1) {
                        c++;
                    } else {
                        c = 0;
                        r++;
                    }
                }
                c = 0;
                r = 0;
            }
        }
        return false;
    }
}
