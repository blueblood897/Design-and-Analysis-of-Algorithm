import java.util.*;
public class ArticulationPoint {
    static List<List<Integer>> Graph = new ArrayList<>();
    static boolean [] visited,articulationCheck;
    static int [] disc,low;
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
        articulationCheck=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,-1);
            }
        }
        int size=0;
        System.out.println("Articulation Points: ");
        for(int i=0;i<n;i++){
            if(articulationCheck[i]){
                System.out.print(i+" ");
                size++;
            }
            
        }
        System.out.println();
        System.out.println(size);
        
        
    }
    static void dfs(int node,int parent){
        visited[node]=true;
        disc[node]=low[node]=++time;
        int children=0;
        for(int p:Graph.get(node)){
            if(p==parent) continue;
            if(!visited[p]){
                children++;
                dfs(p,node);
                low[node]=Math.min(low[node],low[p]);
                if(low[p]>=disc[node]  && parent!=-1){
                    articulationCheck[node]=true;
                }
            }else{
                low[node]=Math.min(low[node],disc[p]);
            }
        }
        if(parent==-1 && children>1){
            articulationCheck[node]=true;
        }
            
    }


}