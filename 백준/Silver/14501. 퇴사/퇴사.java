import java.io.*;

import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n+1];
        
        for(int i=1;i<=n;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            int endDay = i+a-1;
            if(endDay > n) continue; 
            
            dy[endDay] = Math.max(dy[endDay], dy[i-1] + b);
            
            for(int j=endDay+1; j<=n; j++){
                dy[j] = Math.max(dy[j], dy[endDay]);
            }
        }
        
        System.out.println(Arrays.stream(dy).max().getAsInt());
    }
}
