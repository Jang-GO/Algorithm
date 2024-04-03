import java.io.*;
import java.util.*;

class Main{
    static boolean ch[];
    static final String FAIL = "use the stairs";
    static class Floor{
        int y;
        int cnt;
        Floor(int y, int cnt){
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int BFS(int f, int s, int g, int u, int d){
        Queue<Floor> Q = new LinkedList<>();
        Q.offer(new Floor(s,0));
        ch[s] = true;
        while(!Q.isEmpty()){
            Floor tmp = Q.poll();
            if(tmp.y == g) return tmp.cnt;
                
            int upFloor = tmp.y + u;
            int dwFloor = tmp.y - d;
            if(upFloor<=f && !ch[upFloor]){
                ch[upFloor]=true;
                Q.offer(new Floor(upFloor, tmp.cnt+1));
            }
            if(dwFloor>=1 && !ch[dwFloor]){
                ch[dwFloor]=true;
                Q.offer(new Floor(dwFloor, tmp.cnt+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ch = new boolean[f+1];
        int answer = BFS(f,s,g,u,d);
        if(answer==-1) System.out.println(FAIL);
        else System.out.println(answer);
    }
}