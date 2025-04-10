//https://www.acmicpc.net/problem/1189
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, K;
    static String[][] arr;
    static boolean[][] visit;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        visit = new boolean[R][C];
        for(int r = 0; r < R; r++) arr[r] = br.readLine().split("");

        bactracking(R-1, 0, 1);
        System.out.println(count);
    }

    static void bactracking(int x, int y, int len){
        // K보다 더 긴 경로는 탐색할 필요 X. 백트래킹
        if(len > K ) return;
        // 목적지 도달하면 백트래킹
        if(x == 0 && y == C-1){
            if(len == K) count ++; // 거리 K이면 answer + 1
            return;
        }

        visit[x][y] = true; // 방문 표시
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX == R || nextY < 0 || nextY == C) continue;
            if(!visit[nextX][nextY] && arr[nextX][nextY].equals(".")) bactracking(nextX, nextY, len+1);
        }
        visit[x][y] = false; // 방문 초기화
    }
}
