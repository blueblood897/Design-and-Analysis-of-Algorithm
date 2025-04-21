// https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/tutorial/


import java.util.*;

public class SccProb1{
    static List<List<Integer>>graph;
    static List<List<Integer>>revgraph;
    static boolean []visited;
    static Stack<Integer>stack;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        graph = new ArrayList<>();
        revgraph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            revgraph.add(new ArrayList<>());

        }
        for(int i=0;i<m;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            graph.get(a).add(b);
            revgraph.get(b).add(a);
        }
        visited=new boolean[n+1];
        stack=new Stack<>();
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs1(i);
            }
        }
        Arrays.fill(visited, false);
        int c=0,d=0;
        while(!stack.empty()){
            int u=stack.pop();
            List<Integer>list=new ArrayList<>();
            if(!visited[u]){
                dfs2(u,list);
                if(list.size()%2==0){
                    d+=list.size();
                }
                else{
                    c+=list.size();
                }
            

            }

        }
        System.out.println(c-d);

    }
    static void dfs1(int u){
        visited[u]=true;
        for(int p:graph.get(u)){
            if(!visited[p]){
                dfs1(p);
            }
        }
        stack.push(u);


    }
    static void dfs2(int u,List<Integer>list){
        visited[u]=true;
        list.add(u);
        for(int p:revgraph.get(u)){
            if(!visited[p]){
                dfs2(p,list);
            }
        }
    }

}