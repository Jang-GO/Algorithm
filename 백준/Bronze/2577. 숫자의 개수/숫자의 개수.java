import java.io.*;

class Main{
    static int[] arr = new int[10];

    public void solution(int ss){
        int tmp=ss;
        while(tmp>0){
            int a = tmp%10;
            tmp/=10;
            arr[a]++;
        }
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int ss = a*b*c;

        T.solution(ss);
        for(int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
    }
}