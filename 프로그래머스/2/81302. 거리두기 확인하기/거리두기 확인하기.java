class Solution {
    private final static String PLACE = "P";
    private final static String EMPTY = "O";
    private final static String PARTITION = "X";
    
    private final static int[] dx = {0,-1,1,0};
    private final static int[] dy = {1,0,0,-1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        for(String[] a: places){
            String[][] room = makeRoom(a);
            if(isDistanced(room)){
                answer[idx++]=1;
            }else answer[idx++]=0;
  
        }
        
        
        
        return answer;
    }
    
    private static String[][] makeRoom(String[] str){
        String[][] value = new String[str.length][];
        for(int i=0;i<str.length;i++){
            value[i] = str[i].split("");
        }
        return value;
    }
    private static boolean isDistanced(String[][] room){
        for(int y=0; y<room.length;y++){
            for(int x=0;x<room[y].length;x++){
                if(!room[y][x].equals(PLACE)) continue;
                if(!isDistanced(y,x,room)) return false;
            }
        }
        return true;
    }    
    private static boolean isDistanced(int y, int x, String[][] room){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(ny < 0 || ny >= room.length || nx <0 || nx>=room[ny].length) continue;
            switch(room[ny][nx]){
                case PLACE: return false;
                case EMPTY:  
                    if(isNext(room, nx, ny, 3-i)) return false;
                    break;
            }
        }
        return true;
    }
    private static boolean isNext(String[][] room, int x, int y, int exclude){
        for(int d = 0; d<4; d++){
            if(d==exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(ny < 0 || ny >=room.length || nx < 0 || nx >=room[ny].length) continue;
            if(room[ny][nx].equals(PLACE)) return true;
        }
        return false;
    }
}