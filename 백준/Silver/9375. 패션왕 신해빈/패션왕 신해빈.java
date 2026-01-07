import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n, String[] arr){
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : arr){
            String[] tmp = str.split(" ");
            String key = tmp[1];
            String value = tmp[0];
            
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            
            map.get(key).add(value);
        }
        
        int answer = 1;
        for(String key : map.keySet()){
            answer *= (map.get(key).size()+1);
        }
        
        return answer - 1;
        
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            
            for(int i=0;i<n;i++) arr[i] = br.readLine();
            
            sb.append(solution(n, arr)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}