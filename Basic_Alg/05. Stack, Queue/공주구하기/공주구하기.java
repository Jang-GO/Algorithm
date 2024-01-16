import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주구하기 {
        public int solution(int n, int k){
            Queue<Integer> qu = new LinkedList<>();
            for(int i=1;i<=n;i++){
                qu.offer(i);
            }
            int cnt=0;
            while(qu.size()!=1){
                cnt++;
                if(cnt==k){
                    qu.poll();
                    cnt=0;
                }
                else qu.offer(qu.poll());
            }
            return qu.poll();

        }
        public static void main(String[] args) throws IOException{
        공주구하기 T = new 공주구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(n,k));
    }
}
