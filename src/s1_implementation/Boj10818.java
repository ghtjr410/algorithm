package s1_implementation;

import java.io.*;
import java.util.*;

public class Boj10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > max) max = value;
            if (value < min) min = value;
        }

        System.out.println(min + " " + max);
    }
}
