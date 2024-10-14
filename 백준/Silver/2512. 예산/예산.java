import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public long calculateCash(int[] arr, int mid){
        long sum=0;
        for(int x:arr){
            if(x < mid) sum += x;
            else sum += mid;
        }
        return sum;
    }
    public int solution(int n,int m, int[] arr){
        Arrays.sort(arr);
        int size = arr.length;
        int lt = 0;
        int rt = arr[size-1];
        int answer = 0;

        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(calculateCash(arr, mid) <= m){
                answer = mid;
                lt = mid + 1;
            }else rt = mid -1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        System.out.println(T.solution(n,m,arr));
    }
}