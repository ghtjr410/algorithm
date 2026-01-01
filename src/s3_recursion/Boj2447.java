package s3_recursion;

import java.io.*;

public class Boj2447 {
    static int count = 0;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        arr = new char[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = ' ';
            }
        }

        star(0, 0, count);

        for (char[] col : arr) {
            for (char row : col) {
                sb.append(row);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int x, int y, int size) {
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;

                star(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}
