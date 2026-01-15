import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i=0;i<a;i++) set.add(br.readLine());

        int cnt = 0;
        List<String> all = new ArrayList<>();

        for(int i=0;i<b;i++){
            String temp = br.readLine();
            if(set.contains(temp)){
                all.add(temp);
                cnt++;
            }
        }

        all.sort(null);
        sb.append(cnt).append("\n");
        for(String str : all) sb.append(str).append("\n");
        System.out.println(sb);
    }
}