import java.io.*;
import java.util.ArrayList;
class Subject{
    String name;
    float score;
    String grade;
    Subject(String name, float score, String grade){
        this.name = name;
        this.score = score;
        this.grade = grade;
    }
}

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Subject> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            String[] ss = br.readLine().split(" ");
            String a = ss[0];
            float b = Float.parseFloat(ss[1]);
            String c = ss[2];
            list.add(new Subject(a, b, c));
        }
        float allPoint = 0.0f;
        float gradePoint= 0.0f;
        for(Subject x:list){
            if(x.grade.equals("P")) continue;
            allPoint+=x.score;
            switch (x.grade) {
                case "A+":
                    gradePoint+= x.score*4.5f;
                    break;
                case "A0":
                    gradePoint+=x.score*4.0f;
                    break;
                case "B+":
                    gradePoint+=x.score*3.5f;
                    break;
                case "B0":
                    gradePoint+=x.score*3.0f;
                    break;
                case "C+":
                    gradePoint+=x.score*2.5f;
                    break;
                case "C0":
                    gradePoint+=x.score*2.0f;
                    break;    
                case "D+":
                    gradePoint+=x.score*1.5f;
                    break;
                case "D0":
                    gradePoint+=x.score*1.0f;
                    break;
                default:
                    break;
            }
        }
        System.out.println(gradePoint/allPoint);
    }
}
