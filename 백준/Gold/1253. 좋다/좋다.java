import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n, int[] arr){
        int cnt = 0;
        if(arr.length < 3) return 0;

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int target = arr[i];
            int lt = 0;
            int rt = n-1;

            while(lt<rt){
                if (lt == i) {
                    lt++;
                    continue;
                }
                if (rt == i) {
                    rt--;
                    continue;
                }
                int sum = arr[lt] + arr[rt];
                if(sum==target) {
                    cnt++;
                    break;
                }
                else if(sum < target) lt++;
                else rt--;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, arr));
    }
}