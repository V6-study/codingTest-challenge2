// https://www.acmicpc.net/problem/18428
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static String[][] map; // 지도
    static ArrayList<int[]> teachers = new ArrayList<>(); // 선생님이 있는 위치
    static ArrayList<int[]> monitors = new ArrayList<>(); // 감시 가능한 위치
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().split(" ");
            for(int j=0; j<N; j++) if(map[i][j].equals("T")) teachers.add(new int[]{i, j});
        }
        for(int[] t : teachers) monitorable(t[0], t[1]);
        if(backtracking(-1, 0)) System.out.println("YES");
        else System.out.println("NO");
    }

    // 선생님이 감시 가능한 위치 찾기
    static void monitorable(int x, int y){
        for(int d=0; d<4; d++){
            boolean toggle = false;
            int i = dx[d]==0?x: dx[d]==-1?N-1:0;
            int j = dy[d]==0?y: dy[d]==-1?N-1:0;
            while(i>=0 && i<N && j>=0 && j<N){
                if(i == x && j == y) break;
                if(map[i][j].equals("S")) toggle = true;
                if(toggle && map[i][j].equals("X") && !set.contains(i+" "+j)){
                    monitors.add(new int[]{i, j});
                    set.add(i+" "+j);
                }
                i+= dx[d];
                j+= dy[d];
            }
        }
    }

    // 감시 가능한 위치 중 3곳 선택. 백트래킹
    static boolean backtracking(int idx, int cnt){
        if(cnt == 3) return allHide();
        for(int i=idx+1; i<monitors.size(); i++){
            int x=monitors.get(i)[0], y=monitors.get(i)[1];
            String temp = map[x][y];
            map[x][y] = "O";
            if(backtracking(idx, cnt+1)) return true;
            map[x][y] = temp;
        }
        return false;
    }

    // 학생들이 전부 숨었는지 확인.
    static boolean allHide(){
        for(int[] t:teachers){
            for(int d=0; d<4; d++) {
                int i = t[0], j = t[1];
                while (i >= 0 && i < N && j >= 0 && j < N) {
                    if (map[i][j].equals("S")) return false;
                    if (map[i][j].equals("O")) break;
                    i += dx[d];
                    j += dy[d];
                }
            }
        }
        return true;
    }
}
