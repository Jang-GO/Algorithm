import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node root = new Node();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            root.makeTrie(str);
        }

        for(int i=0;i<m;i++){
            String str = br.readLine();
            if(root.find(str)) cnt++;
        }

        System.out.println(cnt);
    }

    static class Node{
        Map<Character, Node> child;
        Node(){
           child = new HashMap<>();
        }

        public void makeTrie(String str){
            char[] strArr = str.toCharArray();
            Node cur = this;
            for(char c : strArr){
                if(!cur.child.containsKey(c)) cur.child.put(c, new Node());
                cur = cur.child.get(c);
            }
        }

        public boolean find(String str){
            Node cur = this;
            char[] strArr = str.toCharArray();
            for(char c: strArr){
                if(!cur.child.containsKey(c)) return false;
                cur = cur.child.get(c);
            }
            return true;
        }
    }
}
