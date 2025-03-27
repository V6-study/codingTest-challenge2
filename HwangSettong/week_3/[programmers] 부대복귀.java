//https://school.programmers.co.kr/learn/courses/30/lessons/132266
import java.util.*;
class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        map = new HashMap<>();
        for(int[] road: roads){
            if(!map.containsKey(road[0])) map.put(road[0], new ArrayList<Integer>());
            if(!map.containsKey(road[1]))map.put(road[1], new ArrayList<Integer>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        bfs(destination, n);
        return getAnswer(sources);
    }
    
    void bfs(int root, int n){
        dist = new int[n+1];
        Arrays.fill(dist, 100001);
        dist[root] = 0;
        Queue<Integer> path = new LinkedList<>();
        path.offer(root);
        while(!path.isEmpty()){
            int cur = path.poll();
            int next = dist[cur] + 1;
            for(int i: map.get(cur)){
                if(dist[i] == 100001){
                    dist[i] = next;
                    path.offer(i);
                }
            }
        }
    }
    
    int[] getAnswer(int[] sources){
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]] == 100001 ? -1: dist[sources[i]];
        }
        return answer;
    }
}
