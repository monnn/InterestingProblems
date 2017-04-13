import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class AbsolutePermutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] params;
        List<Integer> result;
        for (int i = 0; i < n; i++) {
            params = Arrays.stream(scanner.nextLine().split(" "))
                    .map(s -> Integer.parseInt(s))
                    .toArray(Integer[]::new);
            result = getMinPermutation(params[0], params[1]);
            print(result);
        }
    }

    private static List<Integer> getMin(Integer n, Integer k) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }

        if (k == 0) {
            return array;
        }
        boolean found;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            found = false;
            for (int j = 0; j < array.size(); j++) {
                if (Math.abs(array.get(j) - i) == k) {
                    found = true;
                    result.add(array.get(j));
                    array.remove(j);
                    break;
                }
            }
            if (!found) {
                return new ArrayList<>(Arrays.asList(-1));
            }
        }
        return result;
    }

    private static List<Integer> getMinPermutation(Integer n, Integer k) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }

        if (k == 0) {
            return array;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (array.contains(i - k)) {
                result.add(i - k);
                array.remove(new Integer(i - k));
            } else if (array.contains(i + k)) {
                result.add(i + k);
                array.remove(new Integer(i + k));
            }
        }
        if (result.size() != n) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        return result;
    }

    private static void print(List<Integer> permutation) {
        for (int i = 0; i < permutation.size(); i++) {
            System.out.print(permutation.get(i));
            if (i < permutation.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
