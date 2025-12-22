import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=1;i<=n;i++) qu.offer(i);
        
        while(qu.size() > 1){
            qu.poll();
            
            if(qu.size()==1) break;
            
            qu.offer(qu.poll());
        }
        
        System.out.println(qu.poll());
    }
}