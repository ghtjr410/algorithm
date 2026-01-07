package s6_bfs_dfs;

import java.io.*;
import java.util.*;

public class Boj2606 {
    static List<List<Integer>> adj = new ArrayList<>();
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);

        System.out.println(visited.size() - 1);
    }

    static void dfs(int node) {
        if (!visited.add(node)) return;

        for (int next : adj.get(node)) {
            dfs(next);
        }
    }
}