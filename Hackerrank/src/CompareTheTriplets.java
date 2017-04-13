import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class CompareTheTriplets {

    private static boolean isValid(Integer[] aPoints, Integer[] bPoints) {

        Arrays.stream(aPoints).forEach(number -> {
            if (number > Math.pow(10, 4)) {
                try {
                    throw new Exception("Each element must be less than 10^2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        Arrays.stream(bPoints).forEach(number -> {
            if (number > Math.pow(10, 4)) {
                try {
                    throw new Exception("Each element must be less than 10^2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
        return true;
    }

    private static int[] compare(Integer[] aPoints, Integer[] bPoints)  {
        int[] result = new int[2];
        for (int i = 0; i < aPoints.length; i++) {
            if (aPoints[i] > bPoints[i]) {
                result[0] ++;
            } else if (bPoints[i] > aPoints[i]) {
                result[1] ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] aPoints = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);

        Integer[] bPoints = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .toArray(Integer[]::new);

        if (isValid(aPoints, bPoints)) {
            int[] result = compare(aPoints, bPoints);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
