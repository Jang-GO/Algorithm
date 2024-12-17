import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m, answer = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        visited = new boolean[n+1];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;       
        DFS(1);
        
        for(int i=2;i<=n;i++){
            if(visited[i]) answer++;
        }
        System.out.println(answer);
    }

    public static void DFS(int val){
        for(int v:graph.get(val)){
            if(!visited[v]){
                visited[v] = true;
                DFS(v);
            }
        }
    }
}