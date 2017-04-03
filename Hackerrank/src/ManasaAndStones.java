import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class ManasaAndStones {

    private static List<Integer> getLastStone(int numberOfStones, int a, int b) {
        List<Integer> list = new ArrayList<>();
        int value;
        for (int i = 0; i < numberOfStones; i++) {
            value = 0;
            value += i * a;
            value += (numberOfStones - 1 - i) * b;
            list.add(value);
        }
        return list;
    }

    private static void print(List<Integer> lastStoneValues) {
        Set<Integer> set = new TreeSet<>();
        set.addAll(lastStoneValues);
        set.stream().forEach(el -> System.out.print(el + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int numberOfStones;
        int a;
        int b;
        List<Integer> lastStoneValues;
        for (int i = 0; i < n; i++) {
            numberOfStones = Integer.parseInt(scanner.nextLine());
            a = Integer.parseInt(scanner.nextLine());
            b = Integer.parseInt(scanner.nextLine());
            lastStoneValues = getLastStone(numberOfStones, a, b);
            print(lastStoneValues);
        }
    }
}
