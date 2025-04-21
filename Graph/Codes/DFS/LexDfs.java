import java.util.*;

public class LexDfs {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static List<String> traversal = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();

        Set<String> nodes = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            String[] edge = input.nextLine().split(" ");
            String u = edge[0];
            String v = edge[1];
            nodes.add(u);
            nodes.add(v);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
        }

        for (String node : graph.keySet()) {
            Collections.sort(graph.get(node));
        }

        String start = nodes.iterator().next();
        dfs(start);

        for (String node : traversal) {
            System.out.print(node + " ");
        }
    }

    static void dfs(String u) {
        visited.add(u);
        traversal.add(u);

        for (String v : graph.getOrDefault(u, new ArrayList<>())) {
            if (!visited.contains(v)) {
                dfs(v);
            }
        }
    }
}
