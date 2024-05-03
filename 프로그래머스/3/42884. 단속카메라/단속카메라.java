import java.util.*;

class Solution {
    static class Route implements Comparable<Route>{
        int start;
        int end;
        Route(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Route o){
            if(this.end==o.end) return this.start-o.start;
            return this.end - o.end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        List<Route> list = new ArrayList<>();
        for(int i=0;i<routes.length;i++){
            list.add(new Route(routes[i][0], routes[i][1]));
        }
        Collections.sort(list);
        
        int et = -30000;
        for(Route e:list){
            if(e.start>et){
                et = e.end;
                answer++;
            }
        }
        return answer;
    }
}