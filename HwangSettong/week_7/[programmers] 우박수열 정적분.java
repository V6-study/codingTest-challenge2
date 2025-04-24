//https://school.programmers.co.kr/learn/courses/30/lessons/134239
import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Double> dp = new ArrayList<>();
        dp.add(0.0);
        int n = 0;
        while(k!=1){
            double cal = k;
            if(k%2==0) k/=2;
            else k=k*3+1;
            dp.add(dp.get(n++)+(cal+k)/2);
        }
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++){
            if(ranges[i][0] > n+ranges[i][1]) answer[i] = -1;
            else answer[i] = dp.get(n+ranges[i][1]) - dp.get(ranges[i][0]);
        }
        return answer;
    }
}
