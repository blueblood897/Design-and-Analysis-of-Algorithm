import java.util.*;

public class Topological_Sort {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = input.nextInt();
        int edges = input.nextInt();
        int start = input.nextInt();
        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[vertices + 1];
        
        for (int i = 0; i < edges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            adjList.get(u).add(v);

        }
        if (!visited[start]) {
            toposort(start);
        }
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                toposort(i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        input.close();
    }

    static void toposort(int start) {

        visited[start] = true;

        for (int v : adjList.get(start)) {
            if (!visited[v]) {
                toposort(v);
            }
            

        }
        stack.push(start);
    }
}