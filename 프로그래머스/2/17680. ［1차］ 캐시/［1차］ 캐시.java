import java.util.*;

class Solution {
    private final static int CACHE_HIT = 1;
    private final static int CACHE_MISS = 5;
    private final Deque<String> cache = new ArrayDeque<>();
    
    public int solution(int cacheSize, String[] cities) { 
        if(cacheSize == 0) return cities.length * CACHE_MISS; // 전부 다 캐시 미스
        
        int answer = 0;
        
        for(int i=0;i<cities.length;i++){
            String tar = cities[i].toLowerCase();
            
            if(cache.contains(tar)){ // 캐시 히트
                cache.remove(tar);
                cache.offerLast(tar);
                answer+=CACHE_HIT;
            }else{ // 캐시 미스
                if(cache.size() == cacheSize) cache.poll();
                
                cache.offerLast(tar);
                answer+=CACHE_MISS;
            }
        }
        
        return answer;
    }
}