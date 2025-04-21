import java.io.File;
import java.io.IOException;
import java.util.*;
class Graph{
    int size;
    boolean[] added;
    List<Integer>[] li;
    Graph(int size){
        this.size=size;
        added=new boolean[size];
        li=new ArrayList[size];
        for(int m=0;m<size;m++){
            li[m]=new ArrayList<>();
        }
    }
    
    void addVertices(int u){
        if (!added[u]) { 

            added[u] = true; 

        }
    }
    void addEdge(int u,int v){
        addVertices(u);
        addVertices(v);
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
    void start(int u){
        if (color[u].equals("w")) {

            dfsVisit(u);

        }
       
    }
    void topostart(){

        for(int i = 0; i < g.numberofvertices(); i++) {
            if (color[i].equals("w")) {

                topoDfsVisit(i,stack);
    
            }

        }
        
        
    }
    void topoDfsVisit(int u,Stack<Integer> stack){
        color[u]="g";
        time+=1;
        d[u]=time;
        for(int p:g.adjacentVertices(u)){
            if(color[p].equals("w")){
                prev[p]=u;
                topoDfsVisit(p,stack);
            }
        }
        color[u]="b";
        time+=1;
        f[u]=time;
        stack.push(u); 

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
        

    }
    void printResults() {

        System.out.println(discoveryOrder);

    }
    void topPrintresults() {
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
    void reset() {
        time = 0;
        stack.clear();
        discoveryOrder.clear();
        for (int i = 0; i < g.numberofvertices(); i++) {
            color[i] = "w";
            prev[i] = -1;
            d[i] = 0;
            f[i] = 0;
        }
    }
    
    

}

public class Roll33_Lab2 {
    public static void main(String[] args) throws IOException{
        File file=new File("test.txt");
        try{
            Scanner input=new Scanner(file);
            int vertices=input.nextInt();
            int edges=input.nextInt();
            System.out.println(vertices+" "+edges);
            Graph graph=new Graph(vertices);
            
            for(int k=0;k<edges;k++){
                int vertex1=input.nextInt();
                int vertex2=input.nextInt();
                graph.addVertices(vertex1);
                graph.addVertices(vertex2);
                graph.addEdge(vertex1, vertex2);

            }
            graph.displayGraph();
            Dfs dfs=new Dfs(graph);
            dfs.start(5); 

            dfs.printResults();
            dfs.reset();
            dfs.topostart();
            dfs.topPrintresults();
            
            


        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    

    
}