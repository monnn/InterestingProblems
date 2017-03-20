import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class NonDivisibleSubsets {

    private static int getMaxSubset(Integer[] elements, int k) {
        Map<Integer, Integer> temp = new HashMap<>();

        for(int i = 0; i < elements.length; i++) {
            int current = elements[i] % k;
            temp.compute(current, (key, value) -> (value == null || key == 0) ? 1 : (value + 1));
        }

        int sum = temp.getOrDefault(0, 0);;
        int i = 1;
        for(; 2 * i < k; i++) {
            sum += Math.max(temp.getOrDefault(i, 0), temp.getOrDefault(k - i, 0));
        }

        if(2 * i == k) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        Integer[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .map(i -> Integer.parseInt(i)).toArray(Integer[]::new);
        System.out.println(getMaxSubset(elements, k));
    }
}
