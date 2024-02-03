import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
class Lecture implements Comparable<Lecture>{
    int money;
    int date;
    Lecture(int money, int date){
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture o){
        return o.date - this.date;
    }
}

public class 최대수입스케쥴 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> list){
        int answer=0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 리버스오더가 있으면 내림차순으로 poll
        Collections.sort(list);
        int j=0;
        for(int i=max;i>0;i--){
            for(;j<n;j++){
                if(list.get(j).date<i) break;
                pQ.offer(list.get(j).money);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        최대수입스케쥴 T = new 최대수입스케쥴();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list.add(new Lecture(a, b));
            if(b > max) max = b; //Date의 최대값
        }

        System.out.println(T.solution(list));
    }
}
