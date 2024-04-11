import java.io.*;
import java.util.*;

class Main{
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }
        Arrays.sort(arr);
        long sum=0;
        int rank=1;
        for(int i=0;i<n;i++){
            sum+=Math.abs(arr[i]-rank);
            rank++;
        }
        System.out.println(sum);
    }
}