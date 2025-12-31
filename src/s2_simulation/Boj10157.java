package s2_simulation;

import java.io.*;
import java.util.*;

public class Boj10157 {
    static int col, row;
    static boolean[][] visited;
    static final int[] DC = {0, 1, 0, -1};
    static final int[] DR = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(br.readLine());

        if (target > col * row) {
            System.out.println(0);
            return;
        }

        int[] result = findSeat(target);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] findSeat(int target) {
        visited = new boolean[col][row];
        int c = 0, r = 0;
        int dir = 0;

        for (int num = 1; num <= col * row; num++) {
            visited[c][r] = true;

            if (num == target) {
                return new int[]{c + 1, r + 1};
            }

            int nc = c + DC[dir];
            int nr = r + DR[dir];

            if (needTurn(nc, nr)) {
                dir = (dir + 1) % 4;
                nc = c + DC[dir];
                nr = r + DR[dir];
            }

            c = nc;
            r = nr;
        }

        return new int[]{0, 0};
    }

    static boolean needTurn(int c, int r) {
        if (c < 0 || c >= col || r < 0 || r >= row) {
            return true;
        }
        return visited[c][r];
    }
}
