import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            root.makeTree(s);
        }

        root.printTree(0);
    }
    static class Node{
        Map<String, Node> child = new TreeMap<>();

        public void makeTree(String s){
            Node cur = this;
            int idx = 0;
            for(String str: s.split(" ")){
                if(idx == 0){
                    idx ++;
                    continue;
                }
                if(!cur.child.containsKey(str)) cur.child.put(str, new Node());
                cur = cur.child.get(str);
            }
        }

        public void printTree(int L){
            if(child.isEmpty()) return;
            else{
                for(String ss : child.keySet()){
                    System.out.println("--".repeat(L) + ss);
                    child.get(ss).printTree(L+1);
                }
            }
        }
    }
}
