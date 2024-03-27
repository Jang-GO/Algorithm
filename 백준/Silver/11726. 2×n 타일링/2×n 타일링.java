import java.io.*;

class Main{
    static int[] dy;
    public static int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++){
            dy[i] = (dy[i-1] + dy[i-2])%10007;
        }
        return dy[n];

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<3) dy = new int[3];
        else dy = new int[n+1];
        System.out.println(solution(n));
    }
}