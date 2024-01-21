import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기1 {
    int answer=0;
    int[] dist = {1,-1,5};
    int[] ch;

    public int BFS(int s, int e){
        Queue<Integer> qu = new LinkedList<>();
        ch = new int[10001];
        ch[s]=1;
        qu.offer(s);
        int L=0;

        while(!qu.isEmpty()){
            int len = qu.size();
            for(int i=0;i<len;i++){
                int tmp = qu.poll();
                for(int x:dist){
                    int nx = x+tmp;
                    if(nx==e) return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        qu.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        송아지찾기1 T = new 송아지찾기1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int s = Integer.parseInt(tmp[0]);
        int e = Integer.parseInt(tmp[1]);
        System.out.println(T.BFS(s,e));
    }
}
