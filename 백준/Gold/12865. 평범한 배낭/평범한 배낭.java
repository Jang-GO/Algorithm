import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] dy = new int[k+1];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            int w = Integer.parseInt(ss[0]);
            int v = Integer.parseInt(ss[1]);
            for(int j=k;j>=w;j--){
                dy[j] = Math.max(dy[j], dy[j-w]+v);
            }
        }
        System.out.println(dy[k]);
    }
}