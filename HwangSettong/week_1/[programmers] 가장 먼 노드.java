// https://school.programmers.co.kr/learn/courses/30/lessons/49189
import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        // create graph
        boolean[][] graph = new boolean[n][n];
        for(int[] e:edge){
            graph[e[0]-1][e[1]-1] = true;
            graph[e[1]-1][e[0]-1] = true;
        }
        
        // bfs: get shortest distance
        Queue<Integer> path = new LinkedList<>();
        path.offer(0); // 0번 노드부터 시작
        int[] visit = new int[n];
        Arrays.fill(visit, 60000);
        visit[0] = 0;
        while(!path.isEmpty()){
            int idx = path.poll();
            for(int i=0; i<n; i++){
                if(graph[idx][i] && visit[i] > visit[idx]+1){
                    path.offer(i);
                    visit[i] = visit[idx] + 1;
                }
            }
        }
        
        // get answer
        int maxNum = 0, answer = 1;
        for(int v: visit){
            if(v>maxNum){
                maxNum = v;
                answer = 1;
            } else if(v == maxNum) answer ++;
        }
        
        return answer;
    }
}
