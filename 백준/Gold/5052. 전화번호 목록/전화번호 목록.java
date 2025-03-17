import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            Node root = new Node();
            String[] arr = new String[n];

            for(int j=0;j<n;j++){
                String phoneNumberStr = br.readLine();
                arr[j] = phoneNumberStr;
                root.makeTrie(phoneNumberStr);
            }

            findAnswer(arr, root);
        }
        System.out.println(sb);
    }

    private static void findAnswer(String[] arr, Node root) {
        for(String str: arr){
            if(!root.find(str)){
                sb.append("NO").append("\n");
                return ;
            }
        }
        sb.append("YES").append("\n");
    }

    static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd = false;

        public void makeTrie(String str){
            Node cur = this;
            char[] charArr = str.toCharArray();
            int len = str.length();

            for(int i=0;i<len;i++){
                if(!cur.child.containsKey(charArr[i])) cur.child.put(charArr[i], new Node());
                cur = cur.child.get(charArr[i]);
                if(i == len -1 ) cur.isEnd = true;
            }
        }

        public boolean find(String str){
            Node cur = this;
            for (int i = 0; i < str.length(); i++) {
                if (!cur.child.containsKey(str.charAt(i))) return false;
                cur = cur.child.get(str.charAt(i));
                if (cur.isEnd && i != str.length() - 1) return false;
            }
            return true;
        }
    }
}
