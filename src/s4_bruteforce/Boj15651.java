package s4_bruteforce;

import java.io.*;
import java.util.*;

public class Boj15651 {
    static int n;
    static int m;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m];


        pick(0);
        System.out.println(sb.toString());
    }

    static void pick(int depth) {

        if (depth == m) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            selected[depth] = i;
            pick(depth + 1);
        }
    }
}
