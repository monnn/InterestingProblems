import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class BeautifulPairs {

    private static int findMaxPairs(List<Integer> first, List<Integer> second) {
        int mismatches = 0;
        Set<Integer> visited = new HashSet<>();

        for (int j = 0; j < second.size(); j++) {
            int occ1 = Collections.frequency(first, second.get(j));
            int occ2 = Collections.frequency(second, second.get(j));
            if (occ2 > occ1 && !visited.contains(second.get(j))) {
                mismatches += occ2 - occ1;
                visited.add(second.get(j));
            }
        }
        if (mismatches > 0) {
            return  1 + (second.size() - mismatches);
        } else {
            return second.size() - 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        System.out.println(findMaxPairs(first, second));
    }
}
