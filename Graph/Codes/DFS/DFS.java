import java.util.*;

public class DFS {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] discovery;
    static int[] finishing;
    static Stack<Integer> stack = new Stack<>();
    static int time = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = input.nextInt();
        int edges = input.nextInt();
        int start = input.nextInt();
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[vertices + 1];
        discovery=new int[vertices+1];
        finishing=new int[vertices+1];
        for (int i = 0; i < edges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println("DFS Traversal Order:");

        if (!visited[start]) {
            dfs(start);
        }
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println();

        for (int i = 1; i <= vertices; i++) {
            System.out.println("Node " + i + ": discovery = " + discovery[i] + ", finishing = " + finishing[i]);
        }

        input.close();

    }

    static void dfs(int start) {
        visited[start] = true;

        time++;
        discovery[start] = time;
        System.out.print(start + " ");

        for (int v : adjList.get(start)) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        time++;
        finishing[start] = time;

    }
}
