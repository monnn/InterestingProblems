import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MarsExploration {

    private static int getRadiationCount(String s) {
        int count = 0;
        String sos = "SOS";
        for (int i = 0; i < s.length(); i+=3) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(i + j) != sos.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getRadiationCount(s));
    }
}
