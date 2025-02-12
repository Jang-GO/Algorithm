import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N,r,c,ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        r = Integer.parseInt(tmp[1]);
        c = Integer.parseInt(tmp[2]);

        N = (int)Math.pow(2, N);
        z(0,0);

        System.out.println(ans);

    }

    public static void z(int y, int x){ // 시작점 (최초 원점)

        if(N==1) return;

        N/=2; // 중간 지점

        if (r < y + N && c < x + N) { // 1사분면
            z(y, x);
        }else if(r < y + N && c >= x+ N){ // 2사분면
            ans += N * N ;
            z(y, x+N);
        }else if(r >= y+N && c < x+N){ // 3사분면
            ans += N * N * 2;
            z(y+N, x);
        }else{ // 4사분면
            ans += N * N * 3;
            z(y+N, x+N);
        }

    }
}
