import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class BearAndSteadyGeneDynPro {

    private static int getMinOperations(int n, String string) {

        Map<Character, Integer> excessiveElementsMap = getExcessiveElements(n, string);
        Integer[] excessiveElements = excessiveElementsMap.values().toArray(new Integer[excessiveElementsMap.values().size()]);

        int initialLength = Arrays.stream(excessiveElements).reduce(0, (acc, val) -> acc + val);

        int[] current = new int[4];
        int length = initialLength;
        int[] firstComputationOnRow = new int[4];

        while (length < string.length()) {
            for (int i = 0; i < string.length() - length; i++) {
                if (i == 0) {
                    if (length == initialLength) {
                        current = initializeState(string, initialLength);
                        System.arraycopy(current, 0, firstComputationOnRow, 0, current.length);
                    } else {
                        updateCount(firstComputationOnRow, string.charAt(i + length - 1), 1);
                        System.arraycopy(firstComputationOnRow, 0, current, 0, current.length);
                    }
                } else {
                    updateCount(current, string.charAt(i + length - 1), 1);
                    updateCount(current, string.charAt(i - 1), -1);
                }

                if (contains(excessiveElements, current)) {
                    return length;
                }
            }
            length ++;
        }
        return 0;
    }

    private static void updateCount(int[] array, char element, int operation) {
        int index = element == 'A' ? 0 : element == 'C' ? 1 : element == 'G' ? 2 : element == 'T' ? 3 : -1;
        array[index] = array[index] + operation;
    }

    private static boolean contains(Integer[] excessiveElements, int[] current) {
        for (int i = 0; i < excessiveElements.length; i++) {
            if (current[i] < excessiveElements[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] initializeState(String string, int length) {
        int[] current = new int[4];
        for (int j = 0; j < length; j++) {
            int index = string.charAt(j) == 'A' ?
                    0 : string.charAt(j) == 'C' ?
                    1 : string.charAt(j) == 'G' ?
                    2 : string.charAt(j) == 'T' ?
                    3 : -1;
            current[index]++;
        }
        return current;
    }

    private static Map<Character, Integer> getExcessiveElements(int n, String string) {
        Map<Character, Integer> allElements = new LinkedHashMap<>();
        allElements.put('A', 0);
        allElements.put('C', 0);
        allElements.put('G', 0);
        allElements.put('T', 0);
        string.chars()
                .mapToObj(el -> (char) el)
                .forEach(ch -> allElements.put(ch, allElements.get(ch) + 1));

        Map<Character, Integer> excessiveElements = new LinkedHashMap<>();

        for (Character key : allElements.keySet()) {
            if (allElements.get(key) > n/4) {
                excessiveElements.put(key, (allElements.get(key) - n/4));
            } else {
                excessiveElements.put(key, 0);
            }
        }
        return excessiveElements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        System.out.println(getMinOperations(n, string));
    }
}
