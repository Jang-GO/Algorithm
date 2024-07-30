import java.util.*;
import java.util.stream.*;
class Solution {
    /** @bandage : {시전시간(다채우면 추가회복), 초당 회복, 추가회복량}
      * @health : 플레이어 최대체력
      * @attacks : {{공격을 행하는 시간, 피해량}...}
    */  
    public int solution(int[] bandage, int health, int[][] attacks) {
        int sec = 1;
        int endSec = attacks[attacks.length-1][0];
        Map<Integer, Integer> attackTime = Arrays.stream(attacks).
            collect(Collectors.toMap( p -> p[0], p -> p[1]));
        Player player = new Player(health);
        while(sec<=endSec){
            if(attackTime.containsKey(sec)){
                player.hp-=attackTime.get(sec);
                player.continuity = 0;
                if(player.hp<=0) return -1;
            }else{
                player.continuity++;
                if(player.continuity==bandage[0]){
                    player.continuity=0;
                    player.heal(bandage[1], bandage[2]);
                }else{
                    player.heal(bandage[1]);
                }
            }
            System.out.println(player);
            sec++;
        }
        
        return player.hp;
    }
    
    class Player{
        int maxHp;
        int hp;
        int continuity;
        Player(int hp){
            this.hp = hp;
            this.maxHp = hp;
            this.continuity = 0;
        }
        
        public void heal(int healAmount){
            if(this.hp+healAmount > maxHp) this.hp = maxHp;
            else this.hp +=healAmount;
        }
        
        public void heal(int healAmount, int plusAmount){
            if(this.hp+healAmount+plusAmount > maxHp) this.hp = maxHp;
            else this.hp = this.hp + healAmount + plusAmount;
        }
        
        @Override
        public String toString(){
            return "{ 최대체력 : "+ this.maxHp +", 체력: " + this.hp 
                + " , 연속성공횟수: " + this.continuity + " } ";
        }
    }
}