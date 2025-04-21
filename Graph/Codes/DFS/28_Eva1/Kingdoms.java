// D

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Kingdoms {
    static List<List<Integer>> Graph = new ArrayList<>();
    static List<List<Integer>> revGraph = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static int[] label;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        for (int i = 0; i <= n; i++) {
            Graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            Graph.get(u).add(v);
            revGraph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        label = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);
        int kingdom = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                kingdom++;
                dfs2(u, kingdom);
            }
        }

        System.out.println(kingdom);
        for (int i = 1; i <= n; i++) {
            System.out.print(label[i] + " ");
        }
        input.close();
    }

    static void dfs1(int u) {
        visited[u] = true;
        for (int v : Graph.get(u)) {
            if (!visited[v]) {
                dfs1(v);
            }
        }
        stack.push(u);
    }

    static void dfs2(int u, int kingdomLabel) {
        visited[u] = true;
        label[u] = kingdomLabel;
        for (int v : revGraph.get(u)) {
            if (!visited[v]) {
                dfs2(v, kingdomLabel);
            }
        }
    }
}
