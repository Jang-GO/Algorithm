import java.io.*;
import java.util.*;

class Conference implements Comparable<Conference>{
    int start;
    int end;
    Conference(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Conference o){
        if(this.end==o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}

public class 회의실배정{
    public int solution(int n, List<Conference> arr){
        int answer=0;
        Collections.sort(arr);
        int et=0;
        for(Conference c:arr){
            if(c.start>=et){
                answer++;
                et = c.end;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        회의실배정 T = new 회의실배정();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        List<Conference> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            list.add(new Conference(s,e));
        }       
        System.out.println(T.solution(n,list));
    }
}