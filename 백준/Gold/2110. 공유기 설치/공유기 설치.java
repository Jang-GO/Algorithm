import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static int count(int[] arr, int mid){
        int cnt = 1;
        int ep = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-ep >= mid){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
    public static int solution(int n, int c, int[] arr){
        Arrays.sort(arr);
        int answer=0;
        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid) >= c){
                answer = mid;
                lt = mid + 1;
            }else rt = mid -1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(n,c,arr));
    }
}