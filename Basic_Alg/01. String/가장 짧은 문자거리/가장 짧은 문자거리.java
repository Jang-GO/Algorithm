import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 가장짧은문자거리{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        String s = input[0];
        String t = input[1];

        String[] arr = s.split("");
        int[] intArr = new int[arr.length];
        
        int cnt=99;
        // 1. 오른쪽방향 순회
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(t)){
                cnt=0;
                intArr[i]=cnt;
            }else{
                cnt++;
                intArr[i]=cnt;
            }
        }
        
        // 2. 왼쪽방향 순회
        cnt=99;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].equals(t)){
                cnt=0;
            }else{
                cnt++;
                if(intArr[i]>cnt) intArr[i]=cnt;
            }
        }
        
        // 출력
        for(int i=0;i<intArr.length;i++){
            System.out.print(intArr[i] + " ");
        }
    }
}