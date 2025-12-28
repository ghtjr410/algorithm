package s1_implementation;

import java.io.*;

/**
 * - 연속 조건: 변수로 상태 추적 (point)
 * - 조건 깨지면 초기화
 * - 입력 즉시 처리하면 메모리 절약
 */
public class Boj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String s = br.readLine();

            int total = 0;
            int point = 1;

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (ch == 'X') {
                    point = 1;
                    continue;
                }
                total += point;
                point++;
            }
            System.out.println(total);
        }
    }
}
