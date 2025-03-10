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

    
}

public class ImplementationAL {
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
        

        input.close();
    }
}

// // //Implementation with map and linked list


// // // import java.util.*;

// // // class Graph {
// // //     private Map<Integer, List<Integer>> adjList;

// // //     public Graph() {
// // //         this.adjList = new HashMap<>();
// // //     }

// // //     public void addVertex(int vertex) {
// // //         adjList.putIfAbsent(vertex, new ArrayList<>());
// // //     }

// // //     public void addEdge(int source, int destination) {
// // //         adjList.putIfAbsent(source, new ArrayList<>());
// // //         adjList.putIfAbsent(destination, new ArrayList<>());
// // //         adjList.get(source).add(destination);
// // //         adjList.get(destination).add(source); // Remove this line for a directed graph
// // //     }

// // //     public void printGraph() {
// // //         for (var entry : adjList.entrySet()) {
// // //             System.out.print(entry.getKey() + " -> ");
// // //             System.out.println(entry.getValue());
// // //         }
// // //     }

// // //     public static void main(String[] args) {
// // //         Graph graph = new Graph();
// // //         graph.addVertex(1);
// // //         graph.addVertex(2);
// // //         graph.addVertex(3);
// // //         graph.addEdge(1, 2);
// // //         graph.addEdge(2, 3);
// // //         graph.addEdge(1, 3);
// // //         graph.printGraph();
// // //     }
// // // }
