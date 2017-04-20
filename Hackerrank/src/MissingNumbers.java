import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //use scanner.nextInt() and put them directly to map with the frequency as value?
        List<String> firstList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        int m = Integer.parseInt(scanner.nextLine());
        List<String> secondList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        List<String> result = findMissingNumbers(firstList, secondList);
        printList(result);
    }

    private static List<String> findMissingNumbers(List<String> firstList, List<String> secondList) {
        Set<String> set = new TreeSet<>();
        set.addAll(secondList);
        List<String> extraNumbers = new ArrayList<>();
        for (String el : set) {
            int firstListFreq = Collections.frequency(firstList, el);
            if (firstListFreq == 0 || firstListFreq < Collections.frequency(secondList, el)) {
                extraNumbers.add(el);
            }
        }

        return extraNumbers;
    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size()) {
                System.out.print(" ");
            }
        }
    }
}
