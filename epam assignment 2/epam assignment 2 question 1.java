/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] key;
    static int K;
    static int count = 0;

    static void dfs(int node, int parent, int currentXor) {

        // Include current node's key
        currentXor = currentXor ^ key[node];

        // Check if server is trusted
        if (currentXor >= K) {
            count++;
        }

        // Visit all connected servers
        for (int next : tree[node]) {
            if (next != parent) {
                dfs(next, node, currentXor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N = number of servers, K = threshold
        int N = sc.nextInt();
        K = sc.nextInt();

        // Security keys
        key = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }

        // Create tree
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // N - 1 edges
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        // Root is Server 1
        dfs(1, 0, 0);

        System.out.println(count);
    }
}