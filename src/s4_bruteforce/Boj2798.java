package s4_bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMax(cards, n, m));
    }

    static int findMax(int[] cards, int n, int m) {
        int max = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum == m) return m;
                    if (sum < m && sum > max) max = sum;
                }
            }
        }

        return max;
    }
}
