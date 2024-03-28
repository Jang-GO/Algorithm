import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int n,m,a,b;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    
    public int BFS(){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(a);
        ch[a]=0;

        while(!Q.isEmpty()){
            int root = Q.poll();
            for(int x:graph.get(root)){
                if(ch[x]==-1){
                    ch[x] = ch[root]+1;
                    Q.offer(x);
                    if(x==b) return ch[root]+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        ch = new int[n+1];
        Arrays.fill(ch, -1);
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(T.BFS());

    }
}