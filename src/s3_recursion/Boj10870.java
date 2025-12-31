package s3_recursion;

import java.io.*;

public class Boj10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(f(n));
    }

    static int f(int n) {
        return n < 2 ? n : f(n-1) + f(n-2);
    }
}
