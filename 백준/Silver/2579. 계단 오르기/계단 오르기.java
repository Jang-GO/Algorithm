import java.io.*;

class Main{
    static int n;
    static int[] dy;

    public int solution(int[] arr){
        dy[0] = 0;
        dy[1] = arr[1];
        if(n>=2){
            dy[2] = arr[1]+arr[2];
        }
        for(int i=3;i<=n;i++){
            dy[i] = Math.max(dy[i-2], dy[i-3]+arr[i-1]) +arr[i];
        }
        return dy[n];
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dy = new int[n+1];
        System.out.println(T.solution(arr));
    }
}