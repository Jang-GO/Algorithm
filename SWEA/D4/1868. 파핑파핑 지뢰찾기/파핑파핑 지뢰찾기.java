import java.util.*;
import java.io.*;

class Solution{
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    private static int solution(int n, char[][] arr){
        int answer = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='.' && isSafe(n,arr,i,j)){
                	answer++;
                    click(n, arr, i, j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='.'){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private static void click(int n, char[][] arr, int y, int x){
    	Queue<Point> qu = new ArrayDeque<>();
        qu.offer(new Point(y, x));
        arr[y][x] = '9';
        
        while(!qu.isEmpty()){
            int len = qu.size();
            
            for(int i=0;i<len;i++){
            	Point now = qu.poll();
                

       		    if(!isSafe(n, arr, now.y, now.x)) continue;
                for(int d=0; d<8; d++){
            		int ny = now.y + dy[d];
            		int nx = now.x + dx[d];

            		if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
            		if(arr[ny][nx] != '.') continue;

            		arr[ny][nx] = '9';

                    qu.offer(new Point(ny,nx));
               }
            }
        }
    }
    
    private static boolean isSafe(int n, char[][] arr, int y, int x){
    	for(int i=0;i<8;i++){
        	int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny >= n || ny <0 || nx >=n || nx <0) continue;
            
            if(arr[ny][nx] == '*') return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0;t<T;t++){
				int n = Integer.parseInt(br.readLine());
                char[][] arr = new char[n][n];
                
                for(int i=0;i<n;i++){
                 	String str = br.readLine();
                    for(int j=0;j<n;j++) arr[i][j] = str.charAt(j);
                }
                
                sb.append("#").append(t+1).append(" ").append(solution(n,arr)).append("\n");
            }

            System.out.println(sb);
        }
    
    static class Point{
        int y;
        int x;
        
        Point(int y, int x){
        	this.y = y;
            this.x = x;
        }
    }
}