import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) pQ.offer(Integer.parseInt(st.nextToken()));

        if(pQ.size() < m) {
            System.out.println(pQ.poll());
            return;
        }

        int[] arr = new int[m];
        for(int i=0;i<m;i++) arr[i] += pQ.poll();

        while(!pQ.isEmpty()){
            int minIdx = 0;
            for(int i=0;i<m;i++){
                if(arr[i] < arr[minIdx]) minIdx = i;
            }

            arr[minIdx] += pQ.poll();
        }

        int answer = Arrays.stream(arr).max().getAsInt();

        System.out.println(answer);
    }
}
