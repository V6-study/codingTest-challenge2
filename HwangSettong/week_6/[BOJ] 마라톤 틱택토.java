//https://www.acmicpc.net/problem/3024
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N][N];
      
        String winner = "ongoing";
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                if(".".equals(board[i][j])) continue;
                if(i >= 2){
                    if(board[i][j].equals(board[i-1][j]) && board[i][j].equals(board[i-2][j])) winner = board[i][j]; // 세로
                    if(j >= 2 && board[i][j].equals(board[i-1][j-1]) && board[i][j].equals(board[i-2][j-2])) winner = board[i][j]; // 왼쪽 대각선
                    if(j < N-2 && board[i][j].equals(board[i-1][j+1]) && board[i][j].equals(board[i-2][j+2])) winner = board[i][j]; // 오른쪽 대각선
                }
                if(j >= 2 && board[i][j].equals(board[i][j-1]) && board[i][j].equals(board[i][j-2])) winner = board[i][j]; // 가로
            }
        }
        System.out.println(winner);
    }
}
