package s3_recursion;

import java.io.*;

public class Boj11729 {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        move(n, 1, 3, 2);
//                  1
//        ""   ""   2

        System.out.println(count);
        System.out.println(sb.toString());
    }

    static void move(int n, int start, int end, int mid) {
        if (n == 0) return;

        move(n - 1, start, mid, end);
//             1
//        ""   2    ""

        sb.append(start).append(" ").append(end).append("\n");
        count++;

        move(n - 1, mid, end, start);
//                1
//        ""  ""  2
    }
}
