import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class LisasWorkbook {

    private static int getSpecialProblems(List<Integer> problemsInChapter, int n, int k) {
        int page = 0;
        int left;
        int count = 0;
        int chapterPage;
        for (int i = 0; i < problemsInChapter.size(); i++) {
            left = problemsInChapter.get(i);
            chapterPage = 0;

            while(left >= k) {
                left = left - k;
                page++;
                chapterPage++;

                for (int j = (chapterPage - 1) * k + 1; j < chapterPage * k + 1; j++) {
                    if (j == page) {
                        count++;
                    }
                }
            }
            if (left > 0) {
                page++;
                for (int j = chapterPage * k + 1; j < chapterPage * k  + 1 + left; j++) {
                    if (j == page) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] params = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .toArray(Integer[]::new);
        int n = params[0];
        int k = params[1];

        List<Integer> problemsInChapter = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        System.out.println(getSpecialProblems(problemsInChapter, n ,k));
    }
}
