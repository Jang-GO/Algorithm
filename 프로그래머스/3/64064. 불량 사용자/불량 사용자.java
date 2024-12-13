import java.util.*;

class Solution {
    static Set<Set<String>> comb = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        DFS(user_id, banned_id,new HashSet<>() ,0);
        
        return comb.size();
    }
    
    public static void DFS(String[] user_id, String[] banned_id,Set<String> cur, int cnt){
        if(cnt==banned_id.length){
            comb.add(new HashSet<>(cur));
            return;
        }
        else{
            for(int i=0;i<user_id.length;i++){
                if(!cur.contains(user_id[i]) && isMatched(user_id[i], banned_id[cnt])){
                    cur.add(user_id[i]);
                    DFS(user_id, banned_id,cur, cnt+1);
                    cur.remove(user_id[i]);
                }
            }
        }
    }
    
    public static boolean isMatched(String user, String tar){
            if(tar.length() != user.length()) return false;
            for(int i=0;i<user.length();i++){
                char t1 = user.charAt(i);
                char t2 = tar.charAt(i);    
                if(t2 != '*' && t1 != t2) return false;
            }
        return true;
    }
}