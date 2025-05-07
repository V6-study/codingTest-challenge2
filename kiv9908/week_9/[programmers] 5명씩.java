class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[(int)Math.ceil(names.length/5.0)];
        int index = 0;
        
        for(int i = 0 ;i<names.length;i+=5) {
        	answer[index++]=names[i];
        }
        
        return answer;
    }
}
