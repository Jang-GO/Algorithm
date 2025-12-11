import java.io.*;
import java.util.*;

class Main {
    static List<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] times;
    static int[] indeg;
    static int[] dp;

    private static int solution(int n) {
        Deque<Integer> qu = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = times[i];
            if (indeg[i] == 0) qu.offer(i);
        }

        int answer = 0;

        while (!qu.isEmpty()) {
            int cur = qu.poll();
            answer = Math.max(answer, dp[cur]);

            for (int next : adjList.get(cur)) {
                dp[next] = Math.max(dp[next], dp[cur] + times[next]);

                if (--indeg[next] == 0) {
                    qu.offer(next);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());

        times = new int[n + 1];
        indeg = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                int pre = Integer.parseInt(st.nextToken());
                adjList.get(pre).add(i);
                indeg[i]++;
            }
        }

        System.out.println(solution(n));
    }
}
