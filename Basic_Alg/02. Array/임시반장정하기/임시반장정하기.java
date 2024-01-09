import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 임시반장정하기 {	
	public int solution(int n, int[][] arr){
		int answer=0, max=0;
		for(int i=1; i<=n; i++){
			int cnt=0;
			for(int j=1; j<=n; j++){
				for(int k=1; k<=5; k++){
					if(arr[i][k]==arr[j][k]){
						cnt++;
						break;
					}
				}
			}
			if(cnt>max){
				max=cnt;
				answer=i;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException{
		임시반장정하기 T = new 임시반장정하기();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N+1][6];
		for(int i=1; i<=N; i++){
            String[] tmp = br.readLine().split(" ");
			for(int j=1; j<=5; j++){
				arr[i][j]=Integer.parseInt(tmp[j-1]);
			}
		}
		System.out.print(T.solution(N, arr));
	}
}