
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,D, answer = Integer.MIN_VALUE;
    static int[][] graph;
    static int[] select = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        // 궁수 자리 뽑기
        combi(0,0);

        System.out.println(answer);
    }

    private static void combi(int srcIdx, int tgtIdx){
        if(tgtIdx == 3){
            gameStart();
            return;
        }
        if(srcIdx == M) return;
        select[tgtIdx] = srcIdx;
        combi(srcIdx+1, tgtIdx+1);
        combi(srcIdx+1, tgtIdx);

    }

    private static void gameStart() {
        int[][] gameMap = copyOriginalMap();
        int cnt = 0;

        while(true){
            List<int[]> enemies = new ArrayList<>();
            // 각 굳수마다 쏠 적 계산
            for(int archer : select){
                int[] next = findEnemy(archer, gameMap);
                if(next != null) enemies.add(next);
            }

            // 제거
            for(int[] enemyPoint: enemies){
                if(gameMap[enemyPoint[0]][enemyPoint[1]] == 1){
                    gameMap[enemyPoint[0]][enemyPoint[1]] = 0;
                    cnt++;
                }
            }
            // 적 한 칸 내려오기
            enemyMoveDown(gameMap);

            // 적 확인
            if(!isEnemyRemain(gameMap)) break;
        }
        answer = Math.max(answer, cnt);
    }

    private static boolean isEnemyRemain(int[][] gameMap) {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(gameMap[i][j] == 1) return true;
            }
        }
        return false;
    }

    private static void enemyMoveDown(int[][] gameMap) {
        for(int i=N-1;i>0;i--){
            for(int j=0;j<M;j++){
                gameMap[i][j] = gameMap[i-1][j];
            }
        }
        gameMap[0] = new int[M];
    }

    private static int[] findEnemy(int archer, int[][] gameMap){
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b) -> {
            if(a[2] != b[2]) return a[2] - b[2];
            else return a[1] - b[1];
        });
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(gameMap[i][j] == 1){
                    // i,j 랑 archer 간 거리 계산
                    int distance = Math.abs(N-i) + Math.abs(archer - j);
                    if(distance <= D) pQ.add(new int[]{i,j,distance});
                }
            }
        }

        if(pQ.isEmpty()) return null;
        else return pQ.poll();
    }


    private static int[][] copyOriginalMap(){
        int[][] gameMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                gameMap[i][j] = graph[i][j];
            }
        }
        return gameMap;
    }
}
