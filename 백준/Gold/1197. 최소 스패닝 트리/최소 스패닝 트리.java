
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;
    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main{
    static int[] unf;

    private static int Find(int v){
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]);
    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        ArrayList<Edge> list = new ArrayList<>();
        unf = new int[v+1];
        for(int i=0;i<=v;i++) unf[i] = i;
        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }
        Collections.sort(list);
        int answer = 0;
        for(Edge ob:list){
            int f1 = Find(ob.v1);
            int f2 = Find(ob.v2);
            if(f1 != f2){
                answer += ob.cost;
                Union(f1, f2);
            }
        }
        System.out.println(answer);
    }
}