//https://school.programmers.co.kr/learn/courses/30/lessons/67257
import java.util.regex.*;
import java.util.*;
class Solution {
    // operator 우선순위
    String[][] priorityOp = {{"*", "+", "-"},{"*", "-", "+"},
                              {"+", "*", "-"},{"+", "-", "*"},
                              {"-", "*", "+"},{"-", "+", "*"}};
    
    public long solution(String expression) {
        long answer = 0;
        for(int i = 0; i<6; i++){
            answer = Math.max(answer, Math.abs(getResult(priorityOp[i], 0, expression)));
        }
        return answer;
    }
    
    long getResult(String[] pop, int i, String exp){
        if(exp.matches("[0-9]+")) return Long.parseLong(exp);
        if(exp.length() == 0) return 0;
        String[] exps = exp.split("\\"+pop[i]);
        long res = getResult(pop, i+1, exps[0]);
        
        for(int k=1; k<exps.length; k++){
            if(pop[i].equals("*")) res *= getResult(pop, i+1, exps[k]);
            if(pop[i].equals("+")) res += getResult(pop, i+1, exps[k]);
            if(pop[i].equals("-")) res -= getResult(pop, i+1, exps[k]); 
        }
        return res;
    }
}

    
