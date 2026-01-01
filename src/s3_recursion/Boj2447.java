package s3_recursion;

import java.io.*;

public class Boj2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        draw(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (char[] row : arr) {
            sb.append(row).append("\n");
        }
        System.out.print(sb);
    }

    static void draw(int x, int y, int size) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int next = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                draw(x + i * next, y + j * next, next);
            }
        }
    }
}
