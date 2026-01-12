import java.util.*;
import java.io.*;

class Main{
    static int[][] dy;
    private static void initDy(int n, int[][] arr){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dy[i][j] = arr[i][j] + dy[i][j-1] + dy[i-1][j] - dy[i-1][j-1];
            }
        }
    }
    
    private static int solution(int x1, int y1, int x2, int y2){
        return dy[x2][y2] - dy[x2][y1-1] - dy[x1-1][y2] + dy[x1-1][y1-1];
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][n+1];
        dy = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        initDy(n, arr);
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken()); 
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()); 
            
            sb.append(solution(x1,y1,x2,y2)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}