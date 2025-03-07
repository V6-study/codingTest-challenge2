import java.util.*;
class Solution {
    public class Node{
        int priority;
        int location;
        public Node(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Deque<Node> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        
        for(int i = 0;i<priorities.length;i++){
            q.offer(new Node(i,priorities[i]));
            pq.offer(priorities[i]);
        }
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.priority == pq.peek()){
                pq.poll();
                cnt++;
                
                if(now.location == location){
                    break;
                }
            }else{
                q.offer(now);
            }
        }

        return cnt;
        
    }
}
