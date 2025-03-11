// https://school.programmers.co.kr/learn/courses/30/lessons/169199
import java.util.*;
class Solution {
    char[][] board;
    Integer[][] visit; // 지점 별 최소 이동 
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    
    public int solution(String[] board) {
        return dfs(init(board));
    }
    
    int[] init(String[] input){
        board = new char[input.length][input[0].length()];
        visit = new Integer[input.length][input[0].length()];
        int[] start = {0, 0};
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length(); j++){
                board[i][j] = input[i].charAt(j);
                if(board[i][j] == 'R') start = new int[]{i, j};
            }
        }
        return start;
    }
    
    int dfs(int[] start){
        PriorityQueue<int[]> path = new PriorityQueue<>((o1, o2)->o1[2]-o2[2]);
        path.offer(new int[]{start[0], start[1], 0});
        while(!path.isEmpty()){
            int[] cur = path.poll();
            for(int d=0; d<4; d++){
                int x=cur[0]+dx[d], y=cur[1]+dy[d];
                while(true){
                    if(x==-1||x==board.length||y==-1||y==board[0].length || board[x][y] == 'D'){ // 정지 조건
                        x-=dx[d];
                        y-=dy[d];
                        if(board[x][y] == 'G') return cur[2]+1; // G에 도달
                        if(visit[x][y] == null || visit[x][y] > cur[2]+1){
                            visit[x][y] = cur[2]+1;
                            path.offer(new int[]{x, y, cur[2]+1});
                        }
                        break;
                    }
                    x+=dx[d];
                    y+=dy[d];
                }
            }
        }
        return -1;
    }
}
