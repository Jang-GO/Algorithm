import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public boolean isExist(int a, int[] arr){
        int lt = 0;
        int rt = arr.length-1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid] == a) return true;
            else if(arr[mid] > a) rt = mid -1;
            else lt = mid+1;
        }
        return false;
    }
    public int[] solution(int n, int m, int[] arr1, int[] arr2){
        int[] answer = new int[m];
        Arrays.sort(arr1);
        for(int i=0;i<m;i++){
            if(isExist(arr2[i], arr1)) answer[i] = 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp1 = br.readLine().split(" ");
        int[] arr1 = Arrays.stream(tmp1).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        String[] tmp2 = br.readLine().split(" ");
        int[] arr2 = Arrays.stream(tmp2).mapToInt(Integer::parseInt).toArray();

        for(int x:T.solution(n,m,arr1,arr2)) System.out.print(x + " ");

    }
}