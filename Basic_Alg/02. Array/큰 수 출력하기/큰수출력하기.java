import java.util.*;
import java.io.*;

class 큰수출력하기 {
    public static void main(String[] args) throws IOException{
        큰수출력하기 T = new 큰수출력하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for(int ss:T.solution(N,input)){
            System.out.print(ss + " ");
        }
    }   
    public ArrayList<Integer> solution(int N, String[] input){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(input[0]));
        for(int i=1;i<input.length;i++){
            if(Integer.parseInt(input[i])>Integer.parseInt(input[i-1])) list.add(Integer.parseInt(input[i]));
        }
        return list;
    }
}
