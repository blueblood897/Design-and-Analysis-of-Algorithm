import java.util.*;

public class BFS2 {
    static List<List<Integer>> Graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    static int n;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();

        for (int i = 0; i <= n; i++) {
            Graph.add(new ArrayList<>());
            
        }

        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            Graph.get(u).add(v);
            
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        int start=1;
        distance=bfs(start);
        for (int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " ");
        }
    }
    static int [] bfs(int start) {
        Queue<Integer>queue=new LinkedList<>();
        visited[start]=true;
        queue.add(start);
        int [] d=new int[n+1];
        Arrays.fill(d,-1);
        d[start]=0;
        while(!queue.isEmpty()){
            int u=queue.poll();
            for(int v:Graph.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    queue.add(v);
                    d[v]=d[u]+1;
                }
            }
        }
        return d;

    }
}
