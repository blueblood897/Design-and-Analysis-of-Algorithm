import java.util.*;
public class C {
    static int [][]graph;
    public static void main(String[] args) {
        graph = new int[101][101];
        Scanner input = new Scanner(System.in);
        int r=input.nextInt();
        int c=input.nextInt();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                graph[i][j]=input.nextInt();
            }
        }
        int perimeter=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(graph[i][j]==1){
                    perimeter+=4;
                    if(i>0 && graph[i-1][j]==1){
                        perimeter-=1;
                    }
                    if(i<r-1 && graph[i+1][j]==1){
                        perimeter-=1;
                    }
                    if(j>0 && graph[i][j-1]==1){
                        perimeter-=1;
                    }
                    if(j<c-1 && graph[i][j+1]==1){
                        perimeter-=1;
                    }
                }
                
                
                    
            }
        }
        System.out.println(perimeter);


    }

    
}