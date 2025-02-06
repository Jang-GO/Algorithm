import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        int[] answer = T.solution(n, k);
        printAnswer(sb, answer);
    }

    private int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }

        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            if(cnt==k){
                answer.add(q.poll());
                cnt = 0;
            }else{
                q.offer(q.poll());
            }
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }

    private static void printAnswer(StringBuilder sb, int[] answer) {
        sb.append("<");
        for(int a: answer){
            sb.append(a);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}