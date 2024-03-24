import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        int cnt=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            cnt +=arr[i];
            sum+=cnt;
        }
        System.out.println(sum);
    }
}