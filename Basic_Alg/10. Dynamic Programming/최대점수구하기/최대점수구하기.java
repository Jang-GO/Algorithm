import java.io.*;

public class 최대점수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);  
        int[] dy = new int[m+1];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int ps = Integer.parseInt(input[0]);
            int pt = Integer.parseInt(input[1]); 
            for(int j=m;j>=pt;j--){
                dy[j] = Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);
    }
}
