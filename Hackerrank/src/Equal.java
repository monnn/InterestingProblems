import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class Equal {

    private static int getMinOperations(Integer[] elements) {
        int count = 0;

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (Math.abs(elements[i] - elements[j]) >= 5) {
                    while (elements[i] - elements[j] >= 5) {
                        elements[i] -= 5;
                        count ++;
                    }
                    while (elements[j] - elements[i] >= 5) {
                        elements[j] -= 5;
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (Math.abs(elements[i] - elements[j]) >= 2) {
                    while (elements[i] - elements[j] >= 2) {
                        elements[i] -= 2;
                        count++;
                    }
                    while (elements[j] - elements[i] >= 2) {
                        elements[j] -= 2;
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (Math.abs(elements[i] - elements[j]) >= 1) {
                    if (elements[i] > elements[j]) {
                        elements[i] -= 1;
                    } else {
                        elements[j] -= 1;
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private static int getMinOperationsDynamicProgramming(Integer[] elements) {
        int min = elements[0];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        int[][] results = new int[elements.length][3];

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < 3; j++) {
                int difference = elements[i] - min + j;
                results[i][j] = 0;

                while(true) {
                    if(difference >= 5 ) {
                        difference -= 5;
                        results[i][j]++;
                    } else if(difference >= 2) {
                        difference -= 2;
                        results[i][j]++;
                    } else if (difference >= 1) {
                        difference -= 1;
                        results[i][j]++;
                    } else {
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int current = 0;
            for (int j =  0; j < elements.length; j++) {
                current += results[j][i];
            }
            if (result == 0 || current < result) {
                result = current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer[]> list = new ArrayList<>();
        int n;
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(scanner.nextLine());
            list.add(Arrays.stream(scanner.nextLine().split(" "))
                    .map(el -> Integer.parseInt(el))
                    .toArray(Integer[]::new));
        }

        list.stream().forEach(array -> System.out.println(getMinOperationsDynamicProgramming(array)));
    }
}
