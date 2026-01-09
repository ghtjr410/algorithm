package s6_bfs_dfs;

import java.io.*;
import java.util.*;

public class Boj1697 {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                System.out.println(visited[current]);
                return;
            }

            int[] nextPositions = {
                    current - 1,
                    current + 1,
                    current * 2
            };

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
