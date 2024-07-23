import java.util.*;
import java.util.stream.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>(); 
        for(int[] ss:data){
            list.add(new Data(ss));
        }
        List<Data> tmp = list.stream()
            .filter(n-> n.getxxx(ext) < val_ext)
            .sorted(Comparator.comparing(n->n.getxxx(sort_by)))
            .collect(Collectors.toList());
        int[][] answer = new int[tmp.size()][4];
        for(int i=0;i<answer.length;i++){
            answer[i][0] = tmp.get(i).code;
            answer[i][1] = tmp.get(i).date;
            answer[i][2] = tmp.get(i).maximum;
            answer[i][3] = tmp.get(i).remain;
        }
        return answer;
    }
    class Data{
        public int code;
        public int date;
        public int maximum;
        public int remain;
        
        public int getxxx(String ext){
            switch(ext){
                case "code":
                    return code;
                case "date":
                    return date;
                case "maximum":
                    return maximum;
                default:
                    return remain;
            }
        }
        public void setCode(int code){
            this.code = code;
        }
        public void setDate(int date){
            this.date = date;
        }
        public void setMaximum(int maximum){
            this.maximum = maximum;
        }
        public void setRemain(int remain){
            this.remain = remain;
        }
        public Data(int[] arr){
            this.code = arr[0];
            this.date = arr[1];
            this.maximum = arr[2];
            this.remain = arr[3];
        }
    }
}