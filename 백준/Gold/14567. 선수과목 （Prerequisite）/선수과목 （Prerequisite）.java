import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] deg, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        deg = new int[n+1];
        answer = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            deg[b]++;
        }

        Queue<Subjects> qu = new ArrayDeque<>();
        for(int i=1;i<=n;i++) if(deg[i]==0) qu.offer(new Subjects(i,1));

        while(!qu.isEmpty()){
            Subjects now = qu.poll();
            answer[now.number] = now.req;
            for(int ss : graph.get(now.number)){
                deg[ss]-=1;
                if(deg[ss] == 0){
                    qu.offer(new Subjects(ss, now.req+1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).filter(x -> x>0).forEach(x -> sb.append(x).append(" "));
        System.out.println(sb);
    }

    static class Subjects{
        int number;
        int req;
        Subjects(int number, int req){
            this.number = number;
            this.req = req;
        }
    }
}
