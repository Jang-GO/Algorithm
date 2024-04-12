import java.io.*;
import java.util.*;

class Main{
    static boolean ch[] = new boolean[100001];
    static class Point{
        int x;
        int time;
        Point(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    public int solution(int n, int k){
        if(n == k) return 0;
        ch[n] = true;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(n, 0));

        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            
            int tel_x = tmp.x *2;
            if(tel_x==k) return tmp.time;
            if(tel_x<=100000 && !ch[tel_x]){
                ch[tel_x] = true;
                Q.offer(new Point(tel_x, tmp.time));
            }

            int[] cur = {tmp.x-1, tmp.x+1};
            for(int p:cur){
                if(p==k) return tmp.time+1;
                if(p>=0 && p<=100000 && !ch[p]){
                    ch[p]=true;
                    Q.offer(new Point(p, tmp.time+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        System.out.println(T.solution(n,k));
    }
}