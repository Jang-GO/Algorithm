import java.util.*;
import java.io.*;

class 두배열합치기{
    public int[] solution(int N, int M, int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1!=N && ptr2!=M){
            if(arr1[ptr1]<=arr2[ptr2]){
                list.add(arr1[ptr1]);
                ptr1++;
            }else{
                list.add(arr2[ptr2]);
                ptr2++;
            }
        }
        if(ptr1==N){
            for(int i=ptr2;i<M;i++){
                list.add(arr2[i]);
            }
        }else{
            for(int i=ptr1;i<N;i++){
                list.add(arr1[i]);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
    public static void main(String[] args) throws IOException{
        두배열합치기 T = new 두배열합치기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        String[] tmp1 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr1[i] = Integer.parseInt(tmp1[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            arr2[i] = Integer.parseInt(tmp2[i]);
        }

        for(int ss:T.solution(N,M,arr1,arr2)){
            System.out.print(ss + " ");
        }
    }
}