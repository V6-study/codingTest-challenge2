class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i = 0;i<myString.length();i++) {
        	if("a".equals(""+myString.charAt(i))){
        		answer+=String.valueOf(myString.charAt(i)).toUpperCase();
        	}else if(!"A".equals(""+myString.charAt(i))) {
        		answer+=(""+myString.charAt(i)).toLowerCase();
        		
        	}
        	
        	else {
        		answer+=myString.charAt(i);
        	}
        }
        
        return answer;
    }
}
