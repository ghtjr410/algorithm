package s6_bfs_dfs;

import java.io.*;
import java.util.*;

public class Boj2206 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(map, n, m));
    }

    private static int bfs(int[][] map, int n, int m) {
        if (n == 1 && m == 1) {
            return 1;
        }

        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            int broken = current[3];

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (nx == n - 1 && ny == m - 1) {
                    return dist + 1;
                }

                if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    queue.offer(new int[]{nx, ny, dist + 1, broken});
                }

                if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, dist + 1, 1});
                }
            }
        }

        return -1;
    }
}
