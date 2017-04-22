import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Candies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int index = 0;
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[index++] = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        }
        System.out.println((findMinimumCandies(elements)));
    }

    private static long findMinimumCandies(int[] ratings) {
        int[] candies = new int[ratings.length];
        long count = ratings.length;

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        for (int j = ratings.length - 1; j > 0; j--) {
            if (ratings[j] < ratings[j - 1] && candies[j] + 1 > candies[j - 1]) {
                candies[j - 1] = candies[j] + 1;
            }
        }

        for (int candyCount : candies) {
            count += candyCount;
        }
//        System.out.println(Arrays.toString(candies));
        return count;
    }
}
