import java.io.*;
import java.util.Arrays;

class Main{
    static class Title{
        String name;
        int stat;
        Title(String name, int stat){
            this.name = name;
            this.stat = stat;
        }
    } 
    static StringBuilder sb = new StringBuilder();
    static int[] status;
    static Title[] ch;
    static String[] answer;
    public static void solution(BufferedReader br,int n, int m) throws IOException{
        for(int i=0;i<m;i++){
            int ss = Integer.parseInt(br.readLine());

            int lt = 0;
            int rt = n-1;
            while(lt<=rt){
                int mid = (lt+rt)/2;
                if(ch[mid].stat<ss) lt = mid +1;
                else rt = mid -1;
            }
            sb.append(ch[lt].name).append("\n");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        status = new int[m];
        ch = new Title[n];
        answer = new String[m];

        for(int i=0;i<n;i++){
            String[] ching = br.readLine().split(" ");
            ch[i] = new Title(ching[0], Integer.parseInt(ching[1]));
        }

        solution(br,n,m);
        System.out.println(sb.toString());
    }
}