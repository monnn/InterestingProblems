import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class DesignerPDFViewer {

    private static int computeArea(Integer[] heights, String s) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int[] heightsOfS = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < letters.length(); j++) {
                if (s.charAt(i) == letters.charAt(j)) {
                    heightsOfS[i] = heights[j];
                }
            }
        }
        int maxHeight = 0;
        for (int height: heightsOfS) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight * s.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] heights = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        String s = scanner.nextLine();

        System.out.println(computeArea(heights, s));
    }
}
