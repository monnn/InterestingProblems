import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class SparseArrays {

    private static List<Integer> search(List<String> strings, List<String> queries) {

        // list with count for every query
        List<Integer> countsForEveryQuery = queries.stream()
                .map(query -> searchByQuery(strings, query))
                .collect(Collectors.toList());
        return countsForEveryQuery;
    }

    //returns int, how many times query is present in all strings
    private static Integer searchByQuery(List<String> strings, String query) {

        //list with results for every string
        List<Integer> countsForEveryString = strings.stream()
                .map(stringElement -> searchByQueryInString(stringElement, query))
                .collect(Collectors.toList());

        // sum of all counters
        return countsForEveryString.stream().reduce(0, (Integer acc, Integer val) -> acc + val);
    }

    //returns int; if query is present in a string
    private static int searchByQueryInString(String string, String query) {
        if (string.equals(query)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void print(List<Integer> list) {
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < numberOfStrings; i++) {
            stringList.add(scanner.nextLine());
        }
        int numberOfQueries = Integer.parseInt(scanner.nextLine());
        List<String> queryList = new ArrayList<>();
        for (int i = 0; i < numberOfQueries; i++) {
            queryList.add(scanner.nextLine());
        }

        List<Integer> result = search(stringList, queryList);
        print(result);
    }
}
