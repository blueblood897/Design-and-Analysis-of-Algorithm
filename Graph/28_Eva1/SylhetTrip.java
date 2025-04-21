// A

import java.util.*;

public class SylhetTrip {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int C = input.nextInt(); // number of cities
        int R = input.nextInt(); // number of roads
        int K = input.nextInt(); // fuel units
        int L = input.nextInt(); // starting city

        for (int i = 0; i <= C; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }

        visited = new boolean[C + 1];
        List<Integer> count= new ArrayList<>();
        count=bfs(L, K);
        int size=0;
        for (int i = 0; i < count.size(); i++) {
            size+=graph.get(count.get(i)).size();

        }
        System.out.println(size);
        input.close();
    }
    static List<Integer> bfs(int start, int fuel) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        List<Integer> count= new ArrayList<>();
        while(!queue.isEmpty()){
            if(fuel==0){
               break;
            } 
            int u=queue.poll();
            count.add(u);
            fuel--;
            for(int v:graph.get(u)){
                if(!visited[v] && fuel>0){
                    visited[v]=true;
                    queue.add(v);
                }
            }
        } 
        return count;   
        
    }

    
}
