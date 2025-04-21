import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Bridge {
    static List<List<Integer>>Graph=new ArrayList<>();
    static int [] disc;
    static int [] low;
    static boolean [] visited;
    static List<int[]>bridges=new ArrayList<>();
    static int time=0;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        for(int i=0;i<n;i++){
            Graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=input.nextInt();
            int v=input.nextInt();
            Graph.get(u).add(v);
            Graph.get(v).add(u);
        }
        visited=new boolean[n];
        disc=new int[n];
        low=new int[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1);
            }
        }
        System.out.println("Number of bridges: " + bridges.size());
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }



    }
    static void dfs(int u,int parent){
        visited[u]=true;
        disc[u]=low[u]=++time;
        for(int p:Graph.get(u)){
            if(p==parent) continue;
            if(!visited[p]){
                dfs(p,u);
                low[u]=Math.min(low[p],low[u]);

                if(low[p]>disc[u]){
                    bridges.add(new int[]{u,p});
                }
                
            }
            else{
                low[u]=Math.min(low[u],low[p]);
            }
        }
    }



    
}