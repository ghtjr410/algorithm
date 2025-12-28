package s1_implementation;

import java.io.*;
import java.util.*;

/**
 * 시간 계산은 작은 단위(분)로 통일
 * 음수 → += 전체주기
 * / 로 큰 단위, % 로 작은 단위 복원
 */

public class Boj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(s.nextToken());
        int minute = Integer.parseInt(s.nextToken());

        int total = hour * 60 + minute - 45;
        if (total < 0) {
            total += 24 * 60;
        }

        int resultHour = total / 60;
        int resultMinute = total % 60;

        System.out.println(resultHour + " " + resultMinute);
    }
}
