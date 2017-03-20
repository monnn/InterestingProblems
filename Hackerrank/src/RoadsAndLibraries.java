import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class RoadsAndLibraries {
    private static boolean[] marked;

    private static void dfs(Map<Integer, List<Integer>> adjList, int i) {
        marked[i] = true;
        for (int neighbor : adjList.get(i)) {
            if (!marked[neighbor]) {
                dfs(adjList, neighbor);
            }
        }
    }

    private static long calculateCost(List<Integer[]> queries, long cLib, long cRoad, int n) {
        int count = 0;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (Integer[] query: queries) {
            adjList.computeIfAbsent(query[0], k -> new ArrayList<>());
            adjList.get(query[0]).add(query[1]);

            adjList.computeIfAbsent(query[1], k -> new ArrayList<>());
            adjList.get(query[1]).add(query[0]);
        }
        marked = new boolean[(int)Math.pow(10, 5)];

        for (Map.Entry entry: adjList.entrySet()) {
            if (!marked[(int) entry.getKey()]) {
                dfs(adjList, (Integer) entry.getKey());
                count++;
            }
        }
        int difference = n - adjList.size();
        count += difference;

        long allCities = n;
        long withRoads = (count * cLib) + (allCities - count)*cRoad;
        long withLibraries = allCities*cLib;

        return Math.min(withLibraries, withRoads);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < q; i++) {
            String[] firstLine = scanner.nextLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int cLib = Integer.parseInt(firstLine[2]);
            int cRoad = Integer.parseInt(firstLine[3]);
            List<Integer[]> queries = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String[] query = scanner.nextLine().split(" ");
                int u = Integer.parseInt(query[0]);
                int v = Integer.parseInt(query[1]);
                queries.add(new Integer[]{u, v});
            }
            System.out.println(calculateCost(queries, cLib, cRoad, n));
        }
    }
}
