import java.io.*;

class Main{
    static int[][] mem = new int[31][31];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            System.out.println(combi(b,a));
        }
    }

    public static int combi(int m, int n){
        if(mem[m][n]>0) return mem[m][n];
        if(m==n || n == 0) return 1;
        else return mem[m][n] = combi(m-1,n-1) + combi(m-1, n);
    }
}