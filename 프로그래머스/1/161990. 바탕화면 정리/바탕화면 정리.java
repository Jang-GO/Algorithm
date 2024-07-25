import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        List<Point> list = new ArrayList<>();
        for(int i=0;i<wallpaper.length;i++){
            String[] tmp = wallpaper[i].split("");
            for(int j=0;j<tmp.length;j++){
                if(tmp[j].equals("#")) list.add(new Point(i,j));
            }
        }    
        // 첫 2개는 min값, 뒤 2개는 max+1값
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        
        for(Point p:list){
            int tmpx = p.x;
            int tmpy = p.y;
            if(tmpx<minx) minx = tmpx;
            if(tmpy<miny) miny = tmpy;
            if(tmpx>maxx) maxx = tmpx;
            if(tmpy>maxy) maxy = tmpy;
        }
        return new int[]{minx, miny, maxx+1, maxy+1};
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "x = " + x + "y = " + y;
        }
    }
}