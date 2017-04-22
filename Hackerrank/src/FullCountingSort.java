import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class FullCountingSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] params;
        int index;
        String string;
        Map<Integer, List<String>> elements = new HashMap<>();

        for (int i = 0; i < n; i++) {
            params = scanner.nextLine().split(" ");
            index = Integer.parseInt(params[0]);
            if (i < n/2) {
                string = "-";
            } else {
                string = params[1];
            }
            elements.computeIfAbsent(index, k -> new ArrayList<>());
            elements.get(index).add(string);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            result.append(String.join(" ", elements.get(i)));
            result.append(" ");
        }
        System.out.println(result.toString());
    }
}
