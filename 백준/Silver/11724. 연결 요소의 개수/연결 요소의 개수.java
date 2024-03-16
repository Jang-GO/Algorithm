import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main{
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void DFS(int n){
        if(ch[n]==1){
            return;
        }else{
            ch[n]=1;
            for(int x:graph.get(n)){
                if(ch[x]==0){
                    DFS(x);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);           
        }
       
        ch = new int[n+1];
        int cnt=0;

        for(int i=1;i<=n;i++){
            if(ch[i]==0){
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}