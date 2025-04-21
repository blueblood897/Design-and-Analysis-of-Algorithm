import java.io.File;
import java.io.IOException;
import java.util.*;
class Graph{
    int size;
    
    List<Integer>[] li;
    Graph(int size){
        this.size=size;
        
        li=new ArrayList[size];
        for(int m=0;m<size;m++){
            li[m]=new ArrayList<>();
        }
    }
    
    
    void addEdge(int u,int v){
        
        li[u].add(v);
        

    }
    int numberofvertices(){
        return size;
    }
    List <Integer>adjacentVertices(int u){
        return li[u];
    }
    // void adjacentVertices(int u){
    //     for(int j:li[u]){
    //         System.out.println(j);


    //     }

    // }

    void displayGraph(){
        for(int j=0;j<size;j++){
            System.out.println(j+"-> "+li[j]);
        }
    }


}
class Dfs {

    Graph g;

    String[] color;

    int time;

    int[] prev;

    int[] d;

    int[] f;
    List<Integer> discoveryOrder;
    Stack<Integer> stack;
    static int scc=0;
    


    Dfs(Graph g) {

        this.g = g;

        color = new String[g.numberofvertices()];

        prev = new int[g.numberofvertices()];

        d = new int[g.numberofvertices()];

        f = new int[g.numberofvertices()];

        time = 0;
        discoveryOrder = new ArrayList<>();
        stack = new Stack<>();
        


        

        for (int i = 0; i < g.numberofvertices(); i++) {

            color[i] = "w"; 

            prev[i] = -1; 

            f[i] = d[i] = 0;

        }

    }
    void start(){
        for(int u = 0; u < g.numberofvertices(); u++) {

            
        if (color[u].equals("w")) {

            dfsVisit(u);

        }
    }
       
    }
    void dfsVisit(int u) {

        color[u] = "g"; 

        time += 1;

        d[u] = time;
        discoveryOrder.add(u);


        for (int p : g.adjacentVertices(u)) {

            if (color[p].equals("w")) {

                prev[p] = u; 
                dfsVisit(p);

            }

        }


        color[u] = "b"; 

        time += 1;

        f[u] = time;
        stack.push(u);

    }
    Graph transposeGraph() {
        Graph transposedGraph = new Graph(g.numberofvertices());
        for(int i=0;i<g.numberofvertices();i++){
            for(int j:g.adjacentVertices(i)){
                transposedGraph.addEdge(j,i);
            }

        }
        return transposedGraph;
        

        

        
    }
    void transposeGraphStart(){
        while(!stack.empty()){
            int u=stack.pop();
            if (color[u].equals("w")) {
                scc++;
                transposeGraphDfs(u);
    
            
    
            }
        }

    }
    void transposeGraphDfs(int u){
        color[u] = "g"; 

        time += 1;

        d[u] = time;
        discoveryOrder.add(u);


        for (int p : g.adjacentVertices(u)) {

            if (color[p].equals("w")) {
                

                prev[p] = u; 
                transposeGraphDfs(p);

            }

        }


        color[u] = "b"; 

        time += 1;

        f[u] = time;

    }

        
    void printResults() {

        System.out.println(discoveryOrder);
        

            

    }
    
    void reset() {
        time = 0;
        
        discoveryOrder.clear();
        for (int i = 0; i < g.numberofvertices(); i++) {
            color[i] = "w";
            prev[i] = -1;
            d[i] = 0;
            f[i] = 0;
        }
    }
    int noOfSCC(){
        return scc;
    }
    void sccReset(){
        time = 0;
        
        stack.clear();
        for (int i = 0; i < g.numberofvertices(); i++) {
            color[i] = "w";
            prev[i] = -1;
            d[i] = 0;
            f[i] = 0;
        }
    }
    
    

}


public class SCC {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int vertices=input.nextInt();
        int edges=input.nextInt();
        Graph g=new Graph(vertices);
        for(int i=0;i<edges;i++){
            int u=input.nextInt();
            int v=input.nextInt();
            g.addEdge(u,v);
        }
        Dfs dfs=new Dfs(g);
        dfs.start();
        dfs.printResults();
        dfs.reset();
        Graph transposedGraph = dfs.transposeGraph();
        Dfs dfs2 = new Dfs(transposedGraph);
        dfs2.stack = (Stack<Integer>) dfs.stack.clone();

        dfs2.transposeGraphStart();
        dfs2.printResults();
        System.out.println(dfs2.noOfSCC());
        input.close();
        
    }
}
