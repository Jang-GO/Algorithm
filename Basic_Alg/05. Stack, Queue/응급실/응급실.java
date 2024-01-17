import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Patient{
    int id;
    int priority;

    Patient(int id,int priority){
        this.id = id;
        this.priority = priority;
    }
    
}

public class 응급실 {
    public int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Patient> qu = new LinkedList<>();
        for(int i=0; i<n;i++) qu.offer(new Patient(i, arr[i]));

        while(!qu.isEmpty()){
            Patient tmp = qu.poll();
            for(Patient x:qu){
                if(x.priority>tmp.priority){
                    qu.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        응급실 T = new 응급실();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(T.solution(n,m,arr));
    } 
}
