import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String[] tmp = br.readLine().split(" ");
            String a;
            int b=-1;
            if(tmp.length==1){
                a = tmp[0];
            }else{
                a = tmp[0];
                b = Integer.parseInt(tmp[1]);
            }
            if(a.equals("check")){
                sb.append(set.contains(b) ? "1" : "0").append("\n");
            }else if(a.equals("add")){
                if(set.contains(b)) continue;
                else set.add(b);
            }else if(a.equals("remove")){
                if(!set.contains(b)) continue;
                else set.remove(b);
            }else if(a.equals("toggle")){
                if(set.contains(b)) set.remove(b);
                else set.add(b);
            }else if(tmp.length==1){
                if(a.equals("all")){
                    for(int j=1;j<=20;j++){
                        set.add(j);
                    }
                }else{
                    set.clear();
                }
            }
        }

        System.out.println(sb.toString());
    }
}