//https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int s:scoville) pq.offer(s);
        int answer = 0;
        while(pq.peek() < K){
            answer++;
            int a = pq.poll(); // 가장 안매운 음식
            if(pq.isEmpty()) return -1;
            int b = pq.poll(); // 두번째로 안매운 음식
            pq.offer(a+b*2); // 새로운 음식
        }
        return answer;
    }
}
