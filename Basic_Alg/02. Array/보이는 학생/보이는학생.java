import java.util.*;
import java.io.*;


class 보이는학생{
    public static void main(String[] args) throws IOException {
        보이는학생 T = new 보이는학생();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(tmp[i]);
        }
        System.out.print(T.solution(input));
    }
    public int solution(int[] input){
        int cnt=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            if(input[i]>max){
                max = input[i];
                cnt++;
            }
        }
        return cnt;
    }
}