import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 0 가로 1세로 2대각

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n==1)
                    map[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0, 1));

        br.close();
    }

    static int dfs(int status, int y, int x){
        if(y == N-1 && x == N-1)
            return 1;

        int count = 0;

        if(status == 0 || status == 2){ // 가로, 대각선일 때 가로 이동
            if(x+1 < N && map[y][x+1] != -1)
                count += dfs(0 ,y, x+1);
        }

        if(status == 1 || status == 2){ // 세로, 대각선일 때 세로 이동
            if(y+1 < N && map[y+1][x] != -1)
                count += dfs(1 ,y+1, x);
        }

        if(x+1 < N && y+1 < N && map[y+1][x] != -1 && map[y][x+1] != -1 &&map[y+1][x+1] != -1) // 가로, 세로, 대각선일 때 대각선 이동
            count += dfs(2 ,y+1, x+1);

        return count;
    }
}
