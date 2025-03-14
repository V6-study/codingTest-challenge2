// https://school.programmers.co.kr/learn/courses/30/lessons/77485
import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = generate2D(rows, columns);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] q : queries){
            answer.add(rotate(q[0]-1, q[1]-1, q[2]-1, q[3]-1, arr));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    // 행렬 만들기
    int[][] generate2D(int rows, int columns){
        int[][] arr = new int[rows][columns];
        int i = 1;
        for(int row=0; row<rows; row++){
            for(int col=0; col<columns; col++){
                arr[row][col] = i++;
            }
        }
        return arr;
    }
    // 회전시키고, min 값 반환
    int rotate(int x1, int y1, int x2, int y2, int[][] arr){
        int pre1=arr[x1][y1], pre2=arr[x2][y2];
        int min = Math.min(pre1, pre2);
        for(int dy=1; dy <= y2-y1; dy++){ // 가로 방향 회전
            int temp = arr[x1][y1+dy];
            arr[x1][y1+dy] = pre1;
            pre1 = temp;
            temp = arr[x2][y2-dy];
            arr[x2][y2-dy] = pre2;
            pre2 = temp;
            min = Math.min(min, Math.min(pre1, pre2));
        }
        for(int dx=1; dx <= x2-x1; dx++){ // 세로방향 회전
            int temp = arr[x1+dx][y2];
            arr[x1+dx][y2] = pre1;
            pre1 = temp;
            temp = arr[x2-dx][y1];
            arr[x2-dx][y1] = pre2;
            pre2 = temp;
            min = Math.min(min, Math.min(pre1, pre2));
        }
        return min;
    }
}
