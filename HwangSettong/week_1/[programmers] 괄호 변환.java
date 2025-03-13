//https://school.programmers.co.kr/learn/courses/30/lessons/60058#
import java.util.*;
class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    String convert(String w){
        if(w.equals("")) return w;
        int open =0, close=0; // 여는 괄호, 닫는 괄호 count
        int idx = 0;
        while(idx < w.length()){
            if(w.charAt(idx) == '(') open++;
            else close++;
            if(open == close) break;
            idx++;
        }
        String u = w.substring(0, idx+1);
        String v = w.substring(idx+1, w.length());
        if(correct(u)){
            return u + convert(v);
        }else{
            u = w.substring(1, idx);
            u = u.replaceAll("\\(", "0");
            u = u.replaceAll("\\)", "\\(");
            u = u.replaceAll("0", "\\)");
            return "("+convert(v)+")" + u;
        }
    }
    
    boolean correct(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.add(0);
            else if(stack.isEmpty()) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
