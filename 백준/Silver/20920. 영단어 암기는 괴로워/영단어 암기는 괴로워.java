import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            if(tmp.length() >= m) map.put(tmp, map.getOrDefault(tmp,0) +1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (a,b) -> {
            if(map.get(a) != map.get(b)) return map.get(b) - map.get(a);
            else if(a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        keyList.stream().forEach(a -> sb.append(a).append("\n"));
        System.out.println(sb);
    }
}
