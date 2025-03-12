import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int size = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        int minPaints = Integer.MAX_VALUE;
        // i,j 는 8*8 체스판을 시작할 수 있는 범위
        for (int i = 0; i <= N-size; i++) {
            for (int j = 0; j <= M-size; j++) {
                minPaints = Math.min(minPaints, countPaints(board,i,j,'W'));
                minPaints = Math.min(minPaints, countPaints(board,i,j,'B'));
            }
        }
        System.out.println(minPaints);
    }

    public static int countPaints(char[][] board, int x, int y, char color) {
        int cnt = 0;
        char[][] pattern = createPattern(color);
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[x+i][y+j] != pattern[i][j]) {
                    cnt++;
                }
            }

        }
        return cnt;
    }

    private static char[][] createPattern(char color) {
        char[][] pattern = new char[size][size];
        // 현재 색상의 반대
        char opposite = (color == 'W') ? 'B' : 'W';
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                // 번갈아 가며 색칠
                pattern[i][j] = (i + j) % 2 == 0 ? color : opposite;
            }
        }
        return pattern;
    }

}
