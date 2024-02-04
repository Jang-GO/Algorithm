import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class 원더랜드 {
    static int[] unf;
    
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        unf = new int[v+1];
        ArrayList<Edge> list = new ArrayList<>();
        for(int i=1;i<=v;i++) unf[i]=i;
        for(int i=1;i<=e;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            list.add(new Edge(a, b, c));
        }
        int answer = 0;
        Collections.sort(list);
        for(Edge ob:list){
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if(fv1!=fv2){
                answer+=ob.cost;
                Union(fv1, fv2);
            }
        }
        System.out.println(answer);
    }
}
