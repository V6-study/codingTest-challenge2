import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int[] numlist, int n) {
        List<Integer> list = Arrays.stream(numlist).boxed().collect(Collectors.toList());
        Collections.sort(list, (o1, o2) -> {
            int diff1 = Math.abs(o1 - n);
            int diff2 = Math.abs(o2 - n);
            if (diff1 == diff2) {
                return o2 - o1;
            }
            return diff1 - diff2;
        });
        return list;
    }
}
