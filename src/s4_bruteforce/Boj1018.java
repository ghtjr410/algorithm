package s4_bruteforce;

import java.io.*;
import java.util.*;

public class Boj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int repaint = count(board, i, j);
                answer = Math.min(answer, repaint);
            }
        }

        System.out.println(answer);
    }

    static int count(char[][] board, int x, int y) {
        int bStart = 0;
        int wStart = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char current = board[i][j];

                if ((i + j) % 2 == 0) {
                    if (current != 'B') bStart++;
                    if (current != 'W') wStart++;
                } else {
                    if (current != 'W') bStart++;
                    if (current != 'B') wStart++;
                }
            }
        }

        return Math.min(bStart, wStart);
    }
}
