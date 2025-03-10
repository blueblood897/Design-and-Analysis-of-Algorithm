import java.util.*;

class Graph {
    int size;
    List<Integer>[] li;

    Graph(int size) {
        this.size = size;
        li = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            li[i] = new ArrayList<>();
        }
    }

    void add(int u, int v) {
        li[u].add(v);
        li[v].add(u);
    }

    void neighbours() {
        for (int i = 0; i < size; i++) {
            System.out.println("The neighbours of " + i + " are: " + li[i]);
        }
    }

    boolean check(int u, int v) {
        return li[u].contains(v);  
    }

    void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;

        System.out.println("BFS Traversal starting from node " + start + ":");
        while (!q.isEmpty()) {
            int item = q.poll();
            System.out.print(item + " ");

            for (int i : li[item]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

public class BFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int size = input.nextInt();
        Graph g = new Graph(size);
        
        System.out.print("Enter the number of edges: ");
        int edges = input.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            g.add(a, b);
        }

        g.neighbours();

        System.out.print("Enter the starting node for BFS: ");
        int startNode = input.nextInt();
        g.BFS(startNode);

        input.close();
    }
}
