import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Time implements Comparable<Time>{
    int time;
    int state;
    Time(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o){
        if(this.time==o.time) return this.state - o.state;
        else return this.time-o.time;
    }
}

public class 결혼식 {
    public int solution(int n, List<Time> list){
        int answer=-1;
        Collections.sort(list);
        int cnt=0;
        for(Time ob:list){
            if(ob.state=='s') cnt++;
            else cnt--;
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        결혼식 T = new 결혼식();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            list.add(new Time(a,'s'));
            list.add(new Time(b,'e'));
        }
        System.out.println(T.solution(n,list));
    }
}
