import java.io.*;

class Main{
    static int n;
    public int solution(int[] dy){
        if(n==1) return 1;
        else if(n==2) return 2;
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3;i<=n;i++){
            dy[i] = (dy[i-1] + dy[i-2]) % 15746;
        }
        return dy[n];
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dy = new int[n+1];
        System.out.println(T.solution(dy));
    }
}