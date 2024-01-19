import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분검색 {
    public int solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int answer=-1;
        int lt=0, rt = n-1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                answer = mid+1;
                break;
            }else if(arr[mid]>m) rt = mid-1;
            else lt = mid+1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        이분검색 T = new 이분검색();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m =Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;st2.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(T.solution(n,m,arr));
    }
}
