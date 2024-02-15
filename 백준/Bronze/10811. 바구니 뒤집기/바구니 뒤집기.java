import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=i;
        for(int i=0;i<m;i++){
            String[] tmp1 = br.readLine().split(" ");
            int lt = Integer.parseInt(tmp1[0]);
            int rt = Integer.parseInt(tmp1[1]);
            while(lt<rt){
                int z = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = z;
                lt++; rt--;
            }
        }

        for(int i=1;i<=n;i++) System.out.print(arr[i] + " ");
    }
}