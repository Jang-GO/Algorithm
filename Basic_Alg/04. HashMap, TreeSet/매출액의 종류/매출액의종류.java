import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 매출액의종류 {
    public List<Integer> solution(int N, int K, int[] arr){
        List<Integer> list = new Vector<>();
        Map<Integer, Integer> map = new HashMap<>();

        int lt=0;
        for(int i=0;i<K-1;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        for(int rt=K-1;rt<N;rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            list.add(map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt])==0) map.remove(arr[lt]);
            lt++;
        }
        return list;
    }
    public static void main(String[] args) throws IOException{
        매출액의종류 T = new 매출액의종류();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp1 = br.readLine().split(" ");
        int N = Integer.parseInt(tmp1[0]);
        int K = Integer.parseInt(tmp1[1]);
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        for(int ss:T.solution(N,K,arr)){
            System.out.print(ss + " ");
        }
    }
}
