package s2_simulation;

import java.io.*;
import java.util.*;

public class Boj1244 {

    static int[] switchArr;
    static int switchCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        switchCnt = Integer.parseInt(br.readLine());
        switchArr = new int[switchCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchCnt; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                handleMale(num);
            } else {
                handleFemale(num);
            }
        }

        print();
    }

    static void toggle(int idx) {
        switchArr[idx] = switchArr[idx] == 0 ? 1 : 0;
    }

    static void handleMale(int num) {
        for (int i = num; i <= switchCnt; i += num) {
            toggle(i - 1);
        }
    }

    static void handleFemale(int num) {
        int center = num - 1;
        int left = center - 1;
        int right = center + 1;

        while (left >= 0 && right < switchCnt && switchArr[left] == switchArr[right]) {
            left--;
            right++;
        }

        for (int i = left + 1; i < right; i++) {
            toggle(i);
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switchCnt; i++) {
            sb.append(switchArr[i]);
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            } else if (i < switchCnt - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}