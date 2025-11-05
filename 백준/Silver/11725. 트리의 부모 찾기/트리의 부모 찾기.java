import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    private static void DFS(int root){
        visited[root] = true;

        for(int next: tree.get(root)){
            if(!visited[next]){
                parent[next] = root;
                DFS(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=2;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        DFS(1);

        Arrays.stream(parent)
                .filter(x -> x!=0)
                .forEach(System.out::println);
    }
}
