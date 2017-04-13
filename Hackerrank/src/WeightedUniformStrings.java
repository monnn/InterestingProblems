import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class WeightedUniformStrings {

    private static boolean canMakeUniformString(List<Integer> availableCosts, int n) {
        return availableCosts.contains(n);
    }

    private static List<Integer> initializeCost(String string) {
        List<Integer> costs = new ArrayList<>();
        char current;
        for (int i = 0; i < string.length(); i++) {
            current = string.charAt(i);
            int count = 1;
            int currentElementPrice = current - 96;
            costs.add(currentElementPrice);
            while (i < string.length() - 1 && current == string.charAt(i + 1)) {
                count++;
                i++;
            }
            for (int j = 2; j <= count; j++) {
                costs.add(currentElementPrice * j);
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        List<Integer> availableCosts = initializeCost(string);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(canMakeUniformString(availableCosts, Integer.parseInt(scanner.nextLine())) ? "Yes" : "No");
        }
    }
}
