package s5_backtracking;

import java.io.*;
import java.util.*;

public class Boj15650 {
    static int n, m;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m];

        pick(1, 0);

        System.out.println(sb.toString());
    }

    static void pick(int start, int depth) {
        if (depth == m) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            pick(i + 1, depth + 1);
        }
    }
}

