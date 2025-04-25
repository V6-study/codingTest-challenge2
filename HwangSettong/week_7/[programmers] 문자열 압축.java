//https://school.programmers.co.kr/learn/courses/30/lessons/60057
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int len=1; len<=s.length()/2; len++){
            StringBuilder sb = new StringBuilder(); // 압축한 문자열 저장
            String pre = ""; // 직전에 len 단위로 잘린 문자열
            int cnt = 1; // 반복 횟수
            for(int i=0; i<s.length(); i+=len){
                String cur = s.substring(i, Math.min(i+len, s.length())); // i부터 len 단위로 문자열 자르기
                
                if(pre.equals(cur)) cnt++; // pre와 cur 같으면 cnt 증가    
                else{   // pre와 cur 다르면
                    sb.append((cnt>1?cnt:"")+pre); // sb에 추가
                    pre = cur;  // pre 교체
                    cnt = 1;    // cnt 초기화
                }
            }
            sb.append((cnt>1?cnt:"")+pre); // 마지막 문자열까지 저장
            answer = Math.min(sb.length(), answer); // 압축된 문자열 길이 비교
        }
        return answer;
    }
}
