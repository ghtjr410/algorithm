package s1_implementation;

import java.io.*;

public class Boj2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] arr = line.split(" ");

        boolean ascending = true;
        boolean descending = true;
        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(arr[i]);
            if (i + 1 != num) ascending = false;
            if (8 - i != num) descending = false;
        }

        String result = "mixed";

        if (ascending) {
            result = "ascending";
        }

        if (descending) {
            result = "descending";
        }

        System.out.println(result);
    }
}