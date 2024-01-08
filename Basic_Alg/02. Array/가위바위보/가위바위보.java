import java.io.*;

public class 가위바위보 {
    public static void main(String[] args) throws IOException{
        가위바위보 T = new 가위바위보();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        int[] inA = new int[N];
        int[] inB = new int[N];
        for(int i=0;i<N;i++){
            inA[i] = Integer.parseInt(A[i]);
            inB[i] = Integer.parseInt(B[i]);
        }
        for(String ss:T.solution(inA,inB).split("")){
            System.out.println(ss);
        }
    }
    public String solution(int[] inA, int[] inB){
        // 1: 가위, 2: 바위, 3: 보
        String answer="";
        for(int i=0;i<inA.length;i++){
            if(inA[i]==inB[i]) answer+="D";
            else if(inA[i]==3 &&inB[i]==2) answer+="A";
            else if(inA[i]==1 && inB[i]==3) answer+="A";
            else if(inA[i]==2 && inB[i]==1) answer+="A";
            else answer+="B";
        }
        return answer;
    }
}
