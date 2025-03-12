
import java.util.*;

class Graph {
    int size;
    int vertices;
    List<Integer>[] li;

    Graph(int size,int vertices) {
        this.size = size;
        this.vertices=vertices;
        li = new ArrayList[vertices+1];
        for (int i = 1; i <= vertices; i++) {
            li[i] = new ArrayList<>();
        }

    }

    void add(int u, int v) {
        li[u].add(v);
        

    }
    int adjNodes(int u){
        int count1=0;
        for(int i:li[u]){
            count1++;
        }
        return count1;

    }

    void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer>m=new HashMap<>();
        for(int i=0;i<vertices;i++){
            m.put(i,-1);
        }
        q.add(start);
        visited[start] = true;
        m.put(start,0 );
        
        
        while (!q.isEmpty()) {
            int item = q.poll();
            int distance=m.get(item);
            for (int u : li[item]) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.add(u);
                    m.put(u, distance+1); 
                }
            }
            
        }
        int check=0;
        for(var i:m.entrySet()){
            if(i.getKey()==0){
                continue;
            }
            check++;
            if(check==vertices){
                System.out.print(i.getValue());
                System.out.println();
                break;
            }
            System.out.print(i.getValue()+" ");
        }
        
    }

}

public class Roll_33A {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int E=input.nextInt();
        Graph g=new Graph(E,N);
        for(int i=0;i<E;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            g.add(a, b);

        }
        int check=input.nextInt();
        System.out.println(g.adjNodes(check));
        g.BFS(check);


    }
}
