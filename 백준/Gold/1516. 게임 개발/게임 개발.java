
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static List<Node> nodeList;
    static int[] deg, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        deg = new int[n + 1];
        answer = new int[n + 1];
        graph = new ArrayList<>();
        nodeList = new ArrayList<>(Collections.nCopies(n + 1, null)); // 인덱스 1부터 사용

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());

            Node node = new Node(i, sec, sec);
            nodeList.set(i, node);

            while (st.hasMoreTokens()) {
                int before = Integer.parseInt(st.nextToken());
                if (before == -1) break;

                graph.get(before).add(node);
                deg[i]++;
            }
        }

        solution(n);

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void solution(int n) {
        Queue<Node> qu = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) qu.offer(nodeList.get(i));
        }

        while (!qu.isEmpty()) {
            Node cur = qu.poll();
            answer[cur.num] = cur.sum;

            for (Node next : graph.get(cur.num)) {
                next.sum = Math.max(next.sum, cur.sum + next.sec);
                deg[next.num]--;

                if (deg[next.num] == 0) qu.offer(next);
            }
        }
    }

    static class Node {
        int num;
        int sec;
        int sum;

        Node(int num, int sec, int sum) {
            this.num = num;
            this.sec = sec;
            this.sum = sum;
        }
    }
}
