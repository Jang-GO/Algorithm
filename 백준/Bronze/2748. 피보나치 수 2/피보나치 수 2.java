import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main{
    static int n;
    public void solution(){
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger tmp = BigInteger.ZERO;

        for(int i=2;i<=n;i++){
            tmp = b;
            b = b.add(a);
            a = tmp;
        }

        System.out.println(b);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T.solution();
    }
}