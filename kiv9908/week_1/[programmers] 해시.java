import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1); // 각 의상 종류별 (입는 경우 + 안 입는 경우)
        }

        return answer - 1; // 모든 의상을 안 입는 경우 제외
    }
}
