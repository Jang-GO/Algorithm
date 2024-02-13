import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static int solution() {
        int cnt=0;
        int tmp=0;
        int i=666;
        while(true){
            if(String.valueOf(i).contains("666")){
                cnt++;
                tmp=i;
            }
            if(cnt==n) return tmp;
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(solution());
    }
}
