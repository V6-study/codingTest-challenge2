//https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java#
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        // 요청 큐 {요청시각, 소요시간, 작업번호} 우선순위:요청시각>소요시간>작업번호
        PriorityQueue<int[]> req = new PriorityQueue<>((o1,o2)->{
           if(o1[0] == o2[0]){
               if(o1[1] == o2[1]) return o1[2] - o2[2];
               return o1[1] - o2[1];
           }
            return o1[0] - o2[0];
        });
        for(int i=0; i<jobs.length; i++) req.offer(new int[]{jobs[i][0],jobs[i][1],i});
        // 대기 큐 {요청시각, 소요시간, 작업번호} 우선순위:소요시간>요청시각>작업번호
        PriorityQueue<int[]> wait = new PriorityQueue<>((o1,o2)->{
           if(o1[1] == o2[1]){
               if(o1[0] == o2[0]) return o1[2] - o2[2];
               return o1[0] - o2[0];
           }
            return o1[1] - o2[1];
        });
        int time=req.peek()[0], sum = 0;
        while(!req.isEmpty() || !wait.isEmpty()){
            // 대기큐에 요청 작업 담기
            while(!req.isEmpty() && time >= req.peek()[0]) wait.offer(req.poll());
            if(wait.isEmpty()) time=req.peek()[0];
            else{
                // 대기큐에서 작업 꺼내고 실행하기
                time += wait.peek()[1];
                sum += (time - wait.poll()[0]); // 반환시간 더하기
            }
        }
        return sum/jobs.length;
    }
}
