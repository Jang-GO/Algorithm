import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n/4;i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb.toString());
    }
}