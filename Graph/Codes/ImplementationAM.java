import java.util.Scanner;

class Graph {
    int size;
    int[][] matrix;

    Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    void add(int u, int v) {
            matrix[u][v] = matrix[v][u] = 1;
        
    }

    void neighbours() {
        for (int i = 0; i < size; i++) {
            System.out.print("Neighbours of " + i + ": ");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    boolean check(int u, int v) {
        
            return matrix[u][v] == 1;

}
}
public class ImplementationAM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        Graph g = new Graph(size);

        for(int i=0;i<size;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            g.add(a,b);
        }

        g.neighbours();
        System.out.println(g.check(2, 3));

        input.close();
    }
}