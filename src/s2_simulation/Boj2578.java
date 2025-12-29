package s2_simulation;

import java.io.*;
import java.util.*;

public class Boj2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, int[]> board = new HashMap<>();
        int[] row = new int[5];
        int[] col = new int[5];
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        boolean isBingo = false;
        int count = 0;

        for (int x = 0; x < 5; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (isBingo) {
                break;
            }
            for (int y = 0; y <5; y++) {
                if (isBingo) {
                    break;
                }
                int number = Integer.parseInt(st.nextToken());
                count++;

                int[] pos = board.get(number);
                row[pos[0]]++;
                col[pos[1]]++;
                if (pos[0] == pos[1]) diag1++;
                if (pos[0] + pos[1] == 4) diag2++;

                int bingoCount = 0;

                for (int i = 0; i < 5; i++) {
                    if (row[i] == 5) bingoCount ++;
                    if (col[i] == 5) bingoCount ++;
                }

                if (diag1 == 5) bingoCount++;
                if (diag2 == 5) bingoCount++;

                if (bingoCount >= 3) {
                    isBingo = true;
                }
            }
        }

        System.out.println(count);
    }
}
