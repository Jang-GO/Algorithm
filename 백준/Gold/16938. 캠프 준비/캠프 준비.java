import java.io.*;
import java.util.*;

public class Main {
    static int l,r,x, answer = 0;
    static int[] problems;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());

        // 문제 난이도의 합은 L<= sum <=R
        // 가장 어려운 문제와 가장 쉬운 문제의 차이는 diff >= X
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        problems = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) problems[i] = Integer.parseInt(st.nextToken());

        combi(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        System.out.println(answer);
    }

    private static void combi(int srcIdx, int total, int min, int max, int cnt) {
        if(srcIdx == problems.length){
            if (cnt >= 2 
                    && total >= l
                    && total <= r
                    && (max - min) >= x) {
                answer++;
            }
            return;
        }

        combi(srcIdx+1, total+problems[srcIdx], Math.min(min, problems[srcIdx]),Math.max(max, problems[srcIdx]), cnt+1);
        combi(srcIdx+1, total,min,max, cnt);
    }
}
