import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            int[] cntArr = new int[26];
            for(char c : arr) cntArr[c-'a']++;
            Arrays.sort(arr);

            permutation(arr, "", cntArr);
        }
        System.out.println(sb);
    }

    private static void permutation(char[] arr, String str, int[] cntArr){
        if(str.length() == arr.length){
            sb.append(str).append("\n");
            return;
        }

        for(int i=0;i<26;i++){
            if(cntArr[i] > 0){
                cntArr[i] -= 1;
                permutation(arr, str+(char)(i+'a'), cntArr);
                cntArr[i] += 1;
            }
        }
    }
}