import java.util.*;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class BFSShortestReach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        int[] params;
        int[] edge;
        Map<Integer, Set<Integer>> edges;
        for (int i = 1; i <= q; i++) {
            edges = new HashMap<>();
            params = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int n = params[0];
            int m = params[1];
            for (int j = 0; j < m; j++) {
                edge = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int u = edge[0];
                int v = edge[1];
                edges.computeIfAbsent(u, k -> new LinkedHashSet<>());
                edges.computeIfAbsent(v, k -> new LinkedHashSet<>());

                edges.get(u).add(v);
                edges.get(v).add(u);
            }
            int s = Integer.parseInt(scanner.nextLine());
            printArray(getDistance(n, edges, s));
        }
    }

    private static void printArray(int[] array) {
        for (int element: array) {
            if (element != 0) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    private static int[] getDistance(int n, Map<Integer, Set<Integer>> edges, int root) {
        int[] distances = new int[n + 1];
        int k = 0;
        int depth;

        for (int i = 1; i <= n; i++) {
            if (i != root) {
                depth = getDepth(n, root, i, edges);
                distances[k++] = depth > 0 ? depth * 6 : -1;
            }
        }
        return distances;

    }

    private static int getDepth(int n, int root, int target, Map<Integer, Set<Integer>> edges) {
        boolean[] visited = new boolean[n + 1];
        visited[root] = true;
        int depth = 1;
        int inCurrentLevel = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            if (edges.get(current).contains(target)) {
                return depth;
            }
            inCurrentLevel--;
            if (inCurrentLevel == 0) {
                depth++;
                inCurrentLevel = edges.get(current).size();
            }
            for (Integer node : edges.get(current)) {
                if (!visited[node]) {
                    queue.add(node);
                }
            }
        }
        return -1;
    }
}
