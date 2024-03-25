import java.util.*;
import java.io.*;

class Conference implements Comparable<Conference>{
   int startTime;
   int endTime;
   Conference(int startTime, int endTime){
       this.startTime = startTime;
       this.endTime = endTime;
   }
    @Override
    public int compareTo(Conference o) {
        if(this.endTime==o.endTime) return this.startTime-o.startTime;
        else return this.endTime - o.endTime;
    }
    @Override
    public String toString() {
        return "(" + this.startTime+", "+this.endTime+")";
    } 
    

}

class Main{
    public int solution(int n, List<Conference> list){
        int cnt=0;
        Collections.sort(list);
        // for(Conference e:list){
        //     System.out.println(e);
        // }
        int et=0;
        for(Conference e:list){
            if(e.startTime>=et){
                cnt++;
                et = e.endTime;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Conference> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list.add(new Conference(a, b));
        }
        System.out.println(T.solution(n,list));
    }
}