import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뮤직비디오 {
    private static int count(int cap, int[] arr){
        int cnt = 1, sum=0;
        for(int x:arr){
            if(sum+x>cap){
                cnt++;
                sum=x;
            }else{
                sum+=x;
            }
        }
        return cnt;
    }
    public int solution(int n, int m, int[] arr){
        int answer =-1;
        Arrays.sort(arr);
        int lt = arr[n-1], rt = Arrays.stream(arr).sum();
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(mid,arr)<=m){
                answer=mid;
                rt = mid-1;
            }else lt = mid+1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        뮤직비디오 T = new 뮤직비디오();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n,m,arr));
    }
    
}
