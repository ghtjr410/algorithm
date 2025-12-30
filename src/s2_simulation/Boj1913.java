package s2_simulation;

import java.io.*;

// 배열 좌표계 + 격자 이동 문제

// 안 -> 밖
public class Boj1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int findN = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = size / 2;
        int y = size / 2;
        int dir = 0;
        int step = 1;
        int moved = 0;
        int turnCount = 0;
        int findX = 0, findY = 0;

        for (int num = 1; num <= size * size; num++) {
            arr[x][y] = num;
            if (num == findN) {
                findX = x + 1;
                findY = y + 1;
            }

            x += dx[dir];
            y += dy[dir];
            moved++;

            if (moved == step) {
                dir = (dir + 1) % 4;
                moved = 0;
                turnCount++;
                if (turnCount == 2) {
                    step++;
                    turnCount = 0;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        sb.append(findX).append(" ").append(findY);
        System.out.println(sb);
    }
}

// 밖 -> 안

//public class Boj1913_OutToIn {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//        int findN = Integer.parseInt(br.readLine());
//
//        int[][] arr = new int[size][size];
//        int[] dx = {1, 0, -1, 0};  // 하, 우, 상, 좌
//        int[] dy = {0, 1, 0, -1};
//
//        int x = 0, y = 0;
//        int dir = 0;
//        int findX = 0, findY = 0;
//
//        for (int num = size * size; num >= 1; num--) {
//            arr[x][y] = num;
//            if (num == findN) {
//                findX = x + 1;
//                findY = y + 1;
//            }
//
//            int nx = x + dx[dir];
//            int ny = y + dy[dir];
//
//            boolean outOfBounds = nx < 0 || nx >= size || ny < 0 || ny >= size;
//            boolean filled = !outOfBounds && arr[nx][ny] != 0;
//
//            if (outOfBounds || filled) {
//                dir = (dir + 1) % 4;
//                nx = x + dx[dir];
//                ny = y + dy[dir];
//            }
//
//            x = nx;
//            y = ny;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int[] row : arr) {
//            for (int val : row) {
//                sb.append(val).append(" ");
//            }
//            sb.append("\n");
//        }
//        sb.append(findX).append(" ").append(findY);
//        System.out.println(sb);
//    }
//}


