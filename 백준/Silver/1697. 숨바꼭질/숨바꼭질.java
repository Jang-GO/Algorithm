import java.util.*;
import java.io.*;

class Main{
    public int BFS(int n, int k){
        int ch[] = new int[100001];
        Queue<Integer> Q = new LinkedList<>();
        ch[n] = 1;
        Q.offer(n);
        int L = 0;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len ; i++){
                int tmp = Q.poll();
                if(tmp==k) return L;
                if(tmp+1>=0 && tmp+1<=100000 && ch[tmp+1]==0){
                    ch[tmp+1] = 1;
                    Q.offer(tmp+1);
                }
                if(tmp-1>=0 && tmp-1<=100000 && ch[tmp-1]==0){
                    ch[tmp-1] = 1;
                    Q.offer(tmp-1);
                }
                if(tmp*2>=0 && tmp*2<=100000 && ch[tmp*2]==0){
                    ch[tmp*2] = 1;
                    Q.offer(tmp*2);
                }
            }
            L++;
        }
        return L;
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(n,k));
    }
}