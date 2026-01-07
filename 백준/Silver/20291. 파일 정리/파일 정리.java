import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        
        for(int i=0;i<n;i++){
            String key = br.readLine().split("\\.")[1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}