package s6_bfs_dfs;

import java.io.*;
import java.util.*;

public class Boj7576 {

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int unripeCount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (box[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + DX[d];
                    int ny = y + DY[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (box[nx][ny] != 0) continue;

                    box[nx][ny] = 1;
                    unripeCount--;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(unripeCount == 0 ? days - 1 : -1);
    }
}