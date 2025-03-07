import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = solution(n,arr);

        System.out.print(answer[0] + " " + answer[1]);
    }

    private static int[] solution(int n, int[] arr){
        Arrays.sort(arr);
        int[] answer = new int[2];
        int lt = 0;
        int rt = arr.length-1;
        int min = Integer.MAX_VALUE;

        while(lt < rt){
            int dis = arr[lt] + arr[rt];

            if(Math.abs(dis) < Math.abs(min)){
                min = dis;
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }
            if(dis > 0) rt--;
            else if(dis < 0) lt++;
            else return answer;
        }

        return answer;
    }

}
