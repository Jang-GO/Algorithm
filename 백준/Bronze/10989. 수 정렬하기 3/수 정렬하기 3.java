import java.io.*;

class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[10001];
        for(int i=0;i<n;i++){
            int ss = Integer.parseInt(br.readLine());
            arr[ss]++;
        }
        
        for(int i=1;i<10001;i++){
            for(int j=0;j<arr[i];j++){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}