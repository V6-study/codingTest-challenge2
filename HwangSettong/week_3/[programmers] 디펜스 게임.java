//https://school.programmers.co.kr/learn/courses/30/lessons/142085#
import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 무적권을 사용한 적의 수 오름차순
        PriorityQueue<Integer> useM = new PriorityQueue<>();
        // K만큼은 라운드 진행 가능
        int answer = Math.min(k, enemy.length);
        for(int r=0; r<answer; r++) useM.offer(enemy[r]);
        
        // 현재 라운드 적의 수 > 무적권 사용한 적의 최소 수
        //      true : 남은병사 - 무적권 사용한 적의 최소 수, **무적권 사용**
        //      fasle : 남은병사 - 현재 라운드 적의 수
        for(int r=answer; r<enemy.length; r++){
            if(useM.peek() < enemy[r]){
                n -= useM.poll();
                useM.offer(enemy[r]);
            }else{
                n -= enemy[r];
            }
            
            if(n < 0) break; // 게임 종료
            else answer = r+1;
        }
        return answer;
    }
}


