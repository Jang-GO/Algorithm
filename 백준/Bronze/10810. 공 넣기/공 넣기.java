import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n+1];

        for(int i=1;i<=m;i++){
            String[] tmp1 = br.readLine().split(" ");
            int a = Integer.parseInt(tmp1[0]);
            int b = Integer.parseInt(tmp1[1]);
            int c = Integer.parseInt(tmp1[2]);
            for(;a<=b;a++){
                arr[a] = c;
            }
        }

        for(int i=1;i<=n;i++) System.out.print(arr[i] + " ");
    }
}