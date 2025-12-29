package s2_simulation;

import java.io.*;
import java.util.*;

public class Boj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[100][100];
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minX = Integer.parseInt(st.nextToken());
            int minY = Integer.parseInt(st.nextToken());

            for (int y = minY; y < minY + 10; y++) {
                for (int x = minX; x < minX + 10; x++) {
                    visited[y][x] = true;
                }
            }
        }

        int total = 0;

        for (boolean[] y : visited) {
            for (boolean x : y) {
                if (x) total += 1;
            }
        }

        System.out.println(total);
    }
}
