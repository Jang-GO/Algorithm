import java.util.*;
import java.io.*;

public class 선택정렬 {
    public int[] solution(int n, int[] arr){
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1; j<n;j++){
                if(arr[j]<arr[min]) min=j;
            }
            int tmp=arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException{
        선택정렬 T = new 선택정렬();
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
