//https://school.programmers.co.kr/learn/courses/30/lessons/42895?language=java#
import java.util.*;
class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] dp = new HashSet[9];
        dp[0] = new HashSet<>();
        for(int i=1; i<=8 ;i++){
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
            for(int a=1; a<=i/2; a++){
                int b=i-a; // i = a+b
                // a조합, b조합 숫자 뽑아서 사칙연산 수행 -> i조합에 저장
                for(int aa : dp[a]){
                    for(int bb :dp[b]){
                        if(bb!=0 && aa%bb == 0) dp[i].add(aa/bb); 
                        if(aa!=0 && bb%aa == 0) dp[i].add(bb/aa);
                        dp[i].add(aa*bb);
                        dp[i].add(aa+bb);
                        dp[i].add(aa-bb);
                        dp[i].add(bb-aa);
                    }
                }
            }
            if(dp[i].contains(number)) return i;
        }
        return -1;
    }
}
