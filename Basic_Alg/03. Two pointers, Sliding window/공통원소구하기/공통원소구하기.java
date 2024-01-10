import java.util.*;
import java.io.*;

public class 공통원소구하기 {
    public int[] solution(int N, int M, int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int[] nArr1 = Arrays.copyOf(arr1, arr1.length);
        int[] nArr2 = Arrays.copyOf(arr2, arr2.length);

        Arrays.sort(nArr1);
        Arrays.sort(nArr2);

        int ptr1 =0, ptr2=0;
        while(ptr1<N && ptr2<M){
            if(nArr1[ptr1]==nArr2[ptr2]){
                list.add(nArr1[ptr1]);
                ptr1++;
                ptr2++;
            }else if(nArr1[ptr1]<nArr2[ptr2]){
                ptr1++;
            }else ptr2++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) throws IOException{
        공통원소구하기 T = new 공통원소구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0;st1.hasMoreTokens();i++){
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;st2.hasMoreTokens();i++){
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        for(int ss:T.solution(N,M,arr1,arr2)){
            System.out.print(ss + " ");
        }
    }
}
