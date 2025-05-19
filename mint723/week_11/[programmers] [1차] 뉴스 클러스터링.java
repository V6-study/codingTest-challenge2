import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = strToMap(str1.toLowerCase());
        Map<String, Integer> map2 = strToMap(str2.toLowerCase());
        
        int anb = 0;
        int aub = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        for(String key : allKeys){
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            anb += Math.min(count1, count2);
            aub += Math.max(count1, count2);
        }
        
        if(aub == 0)
            return 65536;
        
        return(int)(((double)anb/aub) * 65536);
        
    }
    
    Map<String, Integer> strToMap(String str){
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<str.length()-1; i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            
            if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z'){
                String key = "" + a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        return map;
    }
}
