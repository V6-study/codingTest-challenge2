import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];
    // 우, 하, 우하, 좌하 방향
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j = 0; j < 19; j++) {
            for(int i = 0; i < 19; i++) {
                if(board[i][j] != 0) {
                    for(int k = 0; k < 4; k++) {
                        // 반대 방향에 같은 돌이 있는지 확인
                        int px = i - dx[k];
                        int py = j - dy[k];
                        if(px >= 0 && px < 19 && py >= 0 && py < 19 && board[px][py] == board[i][j]) {
                            continue; // 이미 다른 시작점에서 카운트 됨
                        }

                        int cnt = 1;
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        while(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == board[i][j]) {
                            cnt++;
                            nx += dx[k];
                            ny += dy[k];
                        }

                        if(cnt == 5) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
