import java.io.*;
import java.util.*;

class Main{
    static ArrayList<String> list = new ArrayList<>();
    public String solution(String str){
        Stack<Character> st = new Stack<>();
        for(char ss:str.toCharArray()){
            if(ss=='(') st.push('(');
            if(ss==')'){
                if(st.isEmpty()) return "NO";
                else st.pop();
            } 
        }
        return st.size()>0 ? "NO" : "YES";

    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String input = br.readLine();
            list.add(T.solution(input));
        }
        for(String ss:list) System.out.println(ss);
    }
}