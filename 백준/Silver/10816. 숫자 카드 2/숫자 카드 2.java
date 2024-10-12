import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<tmp.length;i++){
            int a = Integer.parseInt(tmp[i]);
            map.put(a, map.getOrDefault(a,0) + 1);
        }


        int m = Integer.parseInt(br.readLine());
        int[] answer = new int[m];
        String[] tmp1 = br.readLine().split(" ");
        for(int i=0;i<tmp1.length;i++){
            int a = Integer.parseInt(tmp1[i]);
            if(map.containsKey(a)) answer[i] = map.get(a);
        }

        for(int x:answer) System.out.print(x + " ");
    }
}