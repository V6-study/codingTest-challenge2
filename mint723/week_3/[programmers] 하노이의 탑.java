import java.util.*;

class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> solution(int n) {
        answer = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        return answer;
    }
    
    void move(int N, int start, int to){
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(to);
        
        answer.add(list);
    }
    
    void hanoi(int N, int start, int to, int via){
        if(N == 1)
            move(1, start, to);
        else{
            hanoi(N-1, start, via, to);
            move(N, start, to);
            hanoi(N-1, via, to, start);
        }
    }
}
