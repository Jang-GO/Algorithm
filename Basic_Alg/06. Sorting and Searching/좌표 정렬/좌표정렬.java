import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable<Point>{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x){
            return this.y-o.y;
        }else{
            return this.x-o.x;
        }
    }
}

public class 좌표정렬 {
    public static void main(String[] args) throws IOException {
        좌표정렬 T = new 좌표정렬();
        List<Point> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            list.add(new Point(x, y));
        }
        Collections.sort(list);
        for(Point p:list){
            System.out.println(p.x + " "+ p.y);
        }
    }
}
