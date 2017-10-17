package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    int m = 99;
    String[] labels = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "K"};
    // Adjency vector
    int p2[][] = new int[][]{
        //A,B, C,  D, E , Z
        {0, 4, 2, m, m, m},// A0
        {4, 0, 1, 8, m, m},// B1
        {2, 1, 0, 8, 10, m},// C2
        {m, 8, 8, 0, 2, 6},// D3
        {m, m, 10, 2, 0, 3},// E4
        {m, m, m, 6, 3, 0},// Z5
    };

    int ps[][] = new int[][]{
        //A,B,  C ,  D, E,  F,  G , H , K
        {0, 4, 8, m, m, m, m, m, m}, // A0
        {4, 0, 11, 8, m, m, m, m, m}, // B1
        {8, 11, 0, m, 7, 1, m, m, m}, // C2
        {m, 8, m, 0, 2, m, 7, 4, m}, // D3
        {m, m, 7, 2, 0, 6, m, m, m}, // E4
        {m, m, 1, m, 6, 0, m, 2, m}, // F5
        {m, m, m, 7, m, m, 0, 4, 9}, // G6
        {m, m, m, 4, m, 2, 14, 0, 10}, // H7
        {m, m, m, m, m, m, 9, 10, m}, // K8
    };

    int[][] p = new int[][]{
        {0, 1, 0, 1},
        {1, 0, 1, 0},
        {0, 1, 0, 1},
        {1, 0, 1, 0}
    };

    public Graph() {
//        dijkstra(0, 5);
//        System.out.println(degree(0, p));
        eulerPath(p, 0);
    }

    void eulerPath(int[][] g, int x) {
        if (isIsolated(g) || !isConnected(g)) return;
        // Only zero or two vertices have odd degree allowes
        int c = 0; // Odd vertices count
        for (int i = 0; i < g.length; i++) {
            int d = degree(g, i);
            if (d % 2 != 0) c++;
        }
        if (c != 0 && c != 2) return;
        
    }
    
    void eulerCycle(int g[][], int x) {
        // Condition #1: Non Isolated Vertices
        if (isIsolated(g)) {
            return;
        }
        // Condition #2: Graph is strongly connected
        if (!isConnected(g)) {
            return;
        }
        // Condition #3: All vertices have even degrees
        for (int i = 0; i < g.length; i++) {
            int c = 0;
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] != 0) {
                    c++;
                }
            }
            if (c % 2 != 0) {
                return;
            }
        }

        // Start finding euler circuit
        // d: contains degrees value of vertices
        int[] d = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            d[i] = degree(g, i);
        }
        // q: contains euler path
        Queue<Integer> q = new LinkedList<Integer>();
        
        // s: contains vertices that has not yet is    olated (not fullfiled euler path)
        Stack s = new Stack();
        s.push(0);
        
        while (!s.isEmpty()) {
            int i, t = (int) s.peek();
            // Check if vertice is connected
            for (i = 0; i < g.length; i++) {
                if (g[t][i] != 0) break;
            }
            if (i == g.length) { // vertice i is isolated
                q.add(t);
                s.pop();
            } else {
                g[t][i]--;
                g[i][t]--;
                s.push(i);
            }
        }
        
        // Display euler cycle
        while (!q.isEmpty()) {
            System.out.println(labels[q.remove()]);
        }
    }
    
    void print(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            System.out.print("[");
            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("");
    }

    boolean isIsolated(int g[][]) {
        boolean isolated = true;
        // Check if there is a row full of zero
        for (int i = 0; i < g.length; i++) {
            isolated = true;
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] != 0) {
                    isolated = false;
                }
            }
            if (isolated) {
                return true;
            }
        }
        return false;
    }

    boolean isConnected(int g[][]) {
        // Linked vertices to be put in cp
        boolean[] cp = new boolean[g.length];
        for (int i = 0; i < cp.length; i++) {
            cp[i] = false;
        }

        Stack stack = new Stack();
        stack.push(0);
        cp[0] = true;
        // Every vertices must be linked together
        while (!stack.isEmpty()) {
            int p = (int) stack.pop();
            for (int i = 0; i < g[p].length; i++) {
                if (g[p][i] != 0 && !cp[i]) {
                    stack.push(i);
                    cp[i] = true;
                }
            }
        }
        // If there is one or more vertice is not connected, then the graph is not connected
        for (int i = 0; i < cp.length; i++) {
            if (cp[i] == false) {
                return false;
            }
        }
        return true;
    }

    int degree(int p[][], int x) {
        int d = 0;
        for (int i = 0; i < p[x].length; i++) {
            d += p[x][i];
        }
        return d;
    }

    void dijkstra(int x, int y) {
        int d = ps.length;

        // Visited moves - unreturnable move
        boolean v[] = new boolean[d];
        v[x] = true;

        // Weight of moves
        int w[] = new int[d];
        for (int i = 0; i < w.length; i++) {
            w[i] = m;
        }
        w[x] = 0;

        // Traversing start from x
        int t = x;
        while (true) {
            System.out.print(labels[t]);
            if (t == y) {
                return;
            }
            // Start moving from the best move
            for (int i = 0; i < d; i++) {
                // Check if the move is already moved
                if (v[i] || ps[t][i] == m) {
                    continue;
                }
                // Get weight
                int wp = ps[t][i];
                int wt = wp + w[t];
                // Only override if new weight is smaller
                if (wt < w[i]) {
                    w[i] = wt;
                }
            }

            // Store current weight moves
            int k = -1;
            for (int i = 0; i < d; i++) {
                if (v[i] || w[i] == m) {
                    continue;
                }
                if (k == -1) {
                    k = i;
                }
                // Find min weight of recent moves
                if (w[i] < w[k]) {
                    k = i;
                }
            }

            t = k;
            v[t] = true;
        }

    }

    void print(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] ? "T " : "F ");
        }
        System.out.println("");
    }

    void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
