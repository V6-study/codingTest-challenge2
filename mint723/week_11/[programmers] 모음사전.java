import java.util.*;

class Solution {
    String[] arr = {"A","E","I","O","U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        for(int i=0; i<5; i++){
            dfs(arr[i]);
        }
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word))
                return i+1;
        }
        return 0;
    }
    
    void dfs(String word){
        list.add(word);
        if(word.length() == 5)
            return;
        for(int i=0; i<5; i++){
            dfs(word + arr[i]);
        }
    }
}
