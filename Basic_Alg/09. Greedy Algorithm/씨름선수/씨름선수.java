import java.io.*;
import java.util.*;
class Person implements Comparable<Person>{
    int height;
    int weight;
    Person(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Person o){
        return o.height-this.height;
    }
}

public class 씨름선수 { 
    static int answer=0;
    public void solution(int n,ArrayList<Person> list){
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for(Person p:list){
            if(p.weight>max){
                answer++;
                max = p.weight;
            }
        }
        
    }
    public static void main(String[] args) throws IOException{
        씨름선수 T = new 씨름선수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int h = Integer.parseInt(tmp[0]);
            int w = Integer.parseInt(tmp[1]);
            list.add(new Person(h,w));
        }
        T.solution(n,list);
        System.out.println(answer);

    }
}
