import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("Y",2);
        map.put("F",3);
        map.put("O",4);
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> peoples = new HashSet<>();

        for(int i=0;i<n;i++) peoples.add(br.readLine());

        int size = peoples.size();
        System.out.println(size/(map.get(game)-1));
    }
}