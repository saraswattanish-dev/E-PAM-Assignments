 import java.util.*;
public class Tree {
   


    static ArrayList<Integer>[] tree;
    static int[] key;
    static int K;
    static int count = 0;

    static void dfs(int node, int parent, int xorValue) {

        // XOR from root to current node
        xorValue = xorValue ^ key[node];

        // Check whether current server is trusted
        if (xorValue >= K) {
            count++;
        }

        // Visit children
        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node, xorValue);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        key = new int[n + 1];

        // Security keys
        for (int i = 1; i <= n; i++) {
            key[i] = sc.nextInt();
        }

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // n-1 edges
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        K = sc.nextInt();

        // Start DFS from root = Server 1
        dfs(1, 0, 0);

        System.out.println("count : " + count);
    }
}

