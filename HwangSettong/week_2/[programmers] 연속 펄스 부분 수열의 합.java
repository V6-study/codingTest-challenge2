//https://school.programmers.co.kr/learn/courses/30/lessons/161988
import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long[] dp = new long[sequence.length+1];
        int p = 1;
        for(int i = 0; i<sequence.length; i++){
            dp[i+1] = dp[i]+sequence[i]*p;
            p *= -1;
        }
        long max = Arrays.stream(dp).max().orElse(0);
        long min = Arrays.stream(dp).min().orElse(0);
    
        return max == min ? Math.abs(max) : Math.abs(max-min);
    }
}
