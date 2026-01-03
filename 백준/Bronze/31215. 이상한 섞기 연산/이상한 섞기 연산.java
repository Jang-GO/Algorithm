import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n){
        if(n<=2) return 1;
        return 3;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t=1;t<=TC;t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(solution(n)).append("\n");
        }
        
        System.out.println(sb);
    }
}