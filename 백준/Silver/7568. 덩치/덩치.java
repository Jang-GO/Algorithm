import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static class Person{
        int w, h;
        Person(int w, int h){
            this.w = w;
            this.h = h;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int w = Integer.parseInt(tmp[0]);
            int h = Integer.parseInt(tmp[1]);
            list.add(new Person(w,h));
        }

        for(int i=0;i<n;i++){
            int k = 1;
            Person now = list.get(i);
            for(int j=0;j<n;j++){
                if(i==j) continue;
                else{
                    if(now.w < list.get(j).w && now.h < list.get(j).h) k++;
                }
            }
            sb.append(k).append(" ");
        }

        System.out.println(sb);
    }
}