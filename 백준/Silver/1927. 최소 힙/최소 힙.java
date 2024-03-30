import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
			int ss = Integer.parseInt(br.readLine());
			if(ss!=0){
                pQ.offer(ss);
			}else{
				if(pQ.isEmpty()){
                    answer.add(0);
				}else{
					answer.add(pQ.poll());
				}
				
			}

		}
		for(int x:answer){
			System.out.println(x);
		}
	}
}