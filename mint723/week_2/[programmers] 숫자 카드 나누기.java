class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0]; int gcdB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if(isValid(gcdA, arrayB))
            answer = Math.max(answer, gcdA);
        
        
        if(isValid(gcdB, arrayA))
            answer = Math.max(answer, gcdB);
            
        return answer;
    }
    
    int gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    boolean isValid(int gcd, int[] array){
        for(int num : array){
            if(num % gcd == 0){
                return false;
            }
        }
        return true;
    }
}
