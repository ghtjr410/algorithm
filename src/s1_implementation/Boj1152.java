package s1_implementation;

import java.io.*;
import java.util.*;

/**
 *
 * StringTokenizer는 앞뒤/연속 공백 자동 무시
 * split은 빈 문자열 포함될 수 있음
 * countTokens()로 토큰 개수 바로 확인 가능
 */
public class Boj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());

        System.out.println(s.countTokens());
    }
}
