import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마구간정하기 {
    public int count(int dist, int[] arr){
        int cnt=1;
        int ep = arr[0];
        for(int i=1; i<arr.length; i++){
			if(arr[i]-ep>=dist){
				cnt++;
				ep=arr[i];
			}
		}
        return cnt;
    }
    public int solution(int n, int c, int[] arr){
        int answer=0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(mid,arr)>=c){
                answer = mid;
                lt = mid +1;
            }else rt = mid -1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        마구간정하기 T = new 마구간정하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n,c,arr));
    }
}
