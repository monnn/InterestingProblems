import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class ChocolateFeast {

    private static int getNumberOfChocolates(Integer savings, Integer chocolatePrice, Integer neededWrappers) {
        int allChocolates = savings / chocolatePrice;
        int wrappers = allChocolates;
        int newChocolates;
        while (wrappers >= neededWrappers) {
            newChocolates = wrappers / neededWrappers;
            wrappers %= neededWrappers;
            wrappers += newChocolates;
            allChocolates += newChocolates;
        }
        
        return allChocolates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        for (int i = 0; i < n; i++) {
            Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                    .map(el -> Integer.parseInt(el)).toArray(Integer[]::new);
            System.out.println(getNumberOfChocolates(params[0], params[1], params[2]));
        }
    }
}
