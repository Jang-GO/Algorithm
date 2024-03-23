import java.util.Arrays;
import java.util.Scanner;

class Main{
    static int[] dy;
    public int solution(int n){
        if(n < 3) return -1; 
        dy = new int[Math.max(6, n+1)];
        Arrays.fill(dy, -1);
        dy[3] = 1;
        dy[5] = 1;
        for(int i=6; i<=n; i++){
            if(dy[i-3] > 0){ 
                dy[i] = dy[i-3] + 1;
            }
            if(i % 5 == 0 || (dy[i-5] > 0 && (dy[i] == -1 || dy[i-5] + 1 < dy[i]))){ 
                dy[i] = dy[i-5] + 1;
            }
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1]; 
        System.out.println(T.solution(n));
    }
}
