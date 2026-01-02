package s4_bruteforce;

import java.io.*;

public class Boj2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int m = 1; m < n; m++) {
            if (decompose(m) == n) {
                System.out.println(m);
                return;
            }
        }

        System.out.println(0);
    }

    static int decompose(int m) {
        int sum = m;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }
}
