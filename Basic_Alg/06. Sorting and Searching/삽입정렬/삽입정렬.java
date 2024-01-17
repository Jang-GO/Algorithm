import java.util.*;
import java.io.*;

public class 삽입정렬 {
    public int[] solution(int n, int[] arr){
        for(int i=1;i<n;i++){
            int tmp=arr[i], j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>tmp) arr[j+1]= arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException{
        삽입정렬 T = new 삽입정렬();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int x: T.solution(n,arr)){
            System.out.print(x + " ");
        }
    }
}
