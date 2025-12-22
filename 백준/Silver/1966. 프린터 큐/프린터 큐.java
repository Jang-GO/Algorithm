import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Queue<Doc> qu = new ArrayDeque<>();
            int[] arr = new int[10];
            
            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<n;j++){
                int p = Integer.parseInt(st.nextToken());
                qu.offer(new Doc(j, p));
                arr[p]++;
            }
            
            int printed = 0;
            int max = 9;
            
            while(arr[max]==0) max--;
            
            while(!qu.isEmpty()) {
                Doc now = qu.poll();
                
                if(now.pri == max){
                    printed++;
                    arr[max]--;
                    
                    if (now.idx == m) {
                        System.out.println(printed);
                        break;
                    }
                    
                    if(arr[max]==0) while(max > 0 && arr[max] ==0) max--;
                }else{
                    qu.offer(now);
                }
            }
        }
    }
    
    static class Doc{
        int idx;
        int pri;
        
        Doc(int idx, int pri){
            this.idx = idx;
            this.pri = pri;
        }
    }
}