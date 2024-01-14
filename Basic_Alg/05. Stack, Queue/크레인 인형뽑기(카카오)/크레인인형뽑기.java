import java.util.*;
import java.io.*;

public class 크레인인형뽑기 {

    public int solution(int n, int[][] arr, int m, int[] moves){
        int cnt=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<m;i++){
            int tmp=0;
            int target = moves[i];
            for(int j=0;j<arr.length;j++){
                if(arr[j][target-1]!=0){
                    tmp = arr[j][target-1];
                    arr[j][target-1]=0;
                    if(!st.isEmpty() && st.peek()==tmp){
                        cnt+=2;
                        st.pop();
                    }
                    else st.push(tmp);
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        크레인인형뽑기 T = new 크레인인형뽑기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);  
            }
        }
        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            moves[i] = Integer.parseInt(tmp2[i]);
        } 

        System.out.println(T.solution(n,arr,m,moves));
    }
}
