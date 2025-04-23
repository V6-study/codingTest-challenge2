class Solution {
    public int solution(int price) {
        int answer = price;
        if(answer >= 500_000){
            answer *= 0.80;
        }else if(answer >= 300_000){
            answer *= 0.9;
        }else if(answer >= 100_000){
            answer *= 0.95;
        }
        return answer;
    }
}
