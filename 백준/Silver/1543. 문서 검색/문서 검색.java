import java.io.*;

class Main{
    public int solution(String origin, String comp){
        int cnt=0;
        int idx=0;
        while(true){
            idx = origin.indexOf(comp,idx);
            if(idx==-1) break;
            idx+=comp.length();
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String comp = br.readLine();

        System.out.println(T.solution(origin, comp));
    }
}