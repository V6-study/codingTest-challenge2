//https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=java
class Solution {
    int[] picks; // 각 곡괭이 개수
    int[][] p; // 광물 5개의 각 곡괭이 별 피로도
    int answer = 1500;
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        p = new int[(int)Math.ceil(minerals.length/5.0)][3];
        for(int i=0; i<minerals.length; i+=5){
            for(int j=i; j<i+5&&j<minerals.length; j++){
                p[i/5][0] += 1; // 다이아곡괭이 선택
                p[i/5][1] += minerals[j].equals("diamond")?5:1; // 철곡괭이 선택
                p[i/5][2] += minerals[j].equals("diamond")?25:(minerals[j].equals("iron")?5:1); // 돌곡괭이 선택
            }
        }
        backtracking(0, 0);
        return answer;
    }
    
    void backtracking(int idx, int sum){
        if(idx==p.length||picks[0]==0&&picks[1]==0&&picks[2]==0){
            if(sum < answer) answer = sum; // 최소 피로도 저장
            return;
        }
        // 곡괭이 선택
        for(int i=0; i<3; i++){
            if(picks[i] > 0){
                picks[i]--;
                backtracking(idx+1, sum+p[idx][i]);
                picks[i]++;
            }  
        } 
    }
}
