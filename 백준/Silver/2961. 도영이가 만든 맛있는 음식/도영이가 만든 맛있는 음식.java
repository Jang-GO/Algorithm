import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Food{
        int s, b;
        Food(int s, int b){
            this.s = s;
            this.b = b;
        }
    }
    static int min = Integer.MAX_VALUE;
    static List<Food> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list.add(new Food(s,b));
        }

        DFS(0,1,0,0);
        System.out.println(min);
    }

    private static void DFS(int idx, int sumS, int sumB, int cnt) {
           if(idx==list.size()){
               if(cnt>0) min = Math.min(min, Math.abs(sumS-sumB));
               return;
           }
           DFS(idx+1, sumS*list.get(idx).s, sumB+list.get(idx).b, cnt+1);
           DFS(idx+1, sumS,sumB,cnt);
    }
}
