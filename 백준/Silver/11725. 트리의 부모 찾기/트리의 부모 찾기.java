import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public void DFS(int root){
        visited[root] = true;
        for(int x:list.get(root)){
            if(!visited[x]){
                parent[x] = root;
                DFS(x);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=2;i<=n;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        T.DFS(1);
        
        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }
}