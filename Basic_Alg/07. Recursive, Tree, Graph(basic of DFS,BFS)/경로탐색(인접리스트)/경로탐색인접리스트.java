import java.util.*;
import java.io.*;

/**
 * 인접행렬은 정점의 개수가 너무많을땐 메모리를 너무많이 잡아먹음.
 * 시간, 메모리 둘다 복잡도가 높음
 * 따라서 갈수있는 노드만 담은 인접리스트로 진행하는게 좋음
 */
public class 경로탐색인접리스트 {
    static int n,m,answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int nv:graph.get(v)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }
   public static void main(String[] args) throws IOException{
        경로탐색인접리스트 T = new 경로탐색인접리스트();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        graph = new ArrayList<ArrayList<Integer>>(); 
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
   } 
}
