import java.util.*;

public class MaximumLearningPoints {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] points = new long[N];

        for (int i = 0; i < N; i++) {
            points[i] = sc.nextLong();
        }

        if (N == 0) {
            System.out.println(0);
            return;
        }

        if (N == 1) {
            System.out.println(points[0]);
            return;
        }

        long prev2 = points[0];
        long prev1 = Math.max(points[0], points[1]);

        for (int i = 2; i < N; i++) {

            long take = points[i] + prev2;
            long skip = prev1;

            long current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}