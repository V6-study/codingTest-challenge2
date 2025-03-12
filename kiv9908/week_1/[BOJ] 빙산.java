import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int year;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        List<int[]> list = new ArrayList<>();
        // 1. 배열 저장하기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                list.add(new int[]{i,j});
            }
        }

        while(!isSplit()){
            melt(arr);
            year++;
        }

        System.out.println(year);

    }

    public static boolean isSplit(){
        boolean[][] visited = new boolean[N][M];
        int iceCnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j]>0 && !visited[i][j]){
                    bfs(i,j,visited);
                    iceCnt++;

                    if(iceCnt >=2){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void bfs(int x, int y, boolean[][] visited){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] > 0 && !visited[nx][ny]) { // 빙산이 남아 있고 방문하지 않은 경우
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void melt(int[][] arr){
        int[][] updatedArr = new int[N][M];

        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(arr[i][j] > 0){
                    int zeroCnt = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0){
                            zeroCnt++;
                        }
                    }
                    updatedArr[i][j] = Math.max(arr[i][j]-zeroCnt,0);
                }
            }
        }
        // 배열 복사
        for(int i = 0;i < N;i++){
            System.arraycopy(updatedArr[i],0,arr[i],0,M);
        }
    }
}
