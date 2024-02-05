import java.io.*;
import java.util.*;
class Stone implements Comparable<Stone>{
    int area;
    int hei;
    int wei;
    Stone(int area, int hei, int wei){
        this.area = area;
        this.hei = hei;
        this.wei = wei;
    }
    @Override
    public int compareTo(Stone o){
        return o.area - this.area;
    }
}
public class 가장높은탑쌓기 {
    static int[] dy;
    public int solution(Stone[] arr){
        int answer=0;
        Arrays.sort(arr);
        dy[0] = arr[0].hei;
        answer=dy[0];
        for(int i=1;i<arr.length;i++){
            int max_h=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i].wei<arr[j].wei && dy[j]>max_h){
                    max_h = dy[j];
                }
            } 
            dy[i] = max_h + arr[i].hei;
            answer= Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        가장높은탑쌓기 T = new 가장높은탑쌓기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stone[] arr = new Stone[n]; 
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Stone(a,b,c);
        }
        dy = new int[n];
        System.out.println(T.solution(arr));
    }
}
