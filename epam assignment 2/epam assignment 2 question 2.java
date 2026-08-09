/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N = number of cities
        // M = number of highways
        // D = maximum allowed roads
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graph
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        // Distance from City 1
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        // Capital city
        distance[1] = 0;
        queue.add(1);

        int count = 1; // Capital is included

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next : graph[current]) {

                if (distance[next] == -1) {

                    distance[next] = distance[current] + 1;

                    // Only need to continue up to D roads
                    if (distance[next] <= D) {
                        count++;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(count);
    }
}