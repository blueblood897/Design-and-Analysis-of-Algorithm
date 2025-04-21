import java.util.*;

public class LexBfs {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static Map<String, Integer> distance = new HashMap<>();

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
        bfs(start);

        for (String node : new TreeSet<>(nodes)) {
            System.out.println(node + ": " + distance.getOrDefault(node, -1));
        }
    }

    static void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        distance.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String u = queue.poll();
            for (String v : graph.getOrDefault(u, new ArrayList<>())) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                    distance.put(v, distance.get(u) + 1);
                }
            }
        }
    }
}

