import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public int[] solution(int n, int m, int[] arr, int[] tar){
        int[] answer = Arrays.copyOf(tar,m);
        Arrays.sort(arr);
        for(int i=0;i<m;i++){
            int lt=0;
            int rt = n-1;
            boolean flag = false;
            while(lt<=rt){
                int mid = (lt+rt)/2;
                if(arr[mid]==answer[i]){
                    answer[i]=1;
                    flag = true;
                    break;
                }
                else if(arr[mid]>answer[i]) rt = mid-1;
                else if(arr[mid]<answer[i]) lt = mid+1;
            }
            if(!flag) answer[i]=0;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] tar = new int[m];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            tar[i] = Integer.parseInt(tmp[i]);
        }
        
        for(int x:T.solution(n, m, arr, tar)){
            System.out.println(x);
        }  
    }
}