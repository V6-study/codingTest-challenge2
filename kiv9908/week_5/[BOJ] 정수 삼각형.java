import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(arr[i], -1);
            for (int j = 0; j < N; j++) {
                if(st.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }
        }

        /**
         * 이제까지 합이 최대가 되는 경로에 있는 수의 합
         * 7
         * 3 8
         * 8 1 0
         * 2 7 4 4
         * 4 5 2 6 5
         *
         * 7
         * 10 15
         * 8 1 0
         * 2 7 4 4
         * 4 5 2 6 5
         *
         * 7
         * 10 15
         * 18 16 15
         * 2 7 4 4
         * 4 5 2 6 5
         *
         * 7
         * 10 15
         * 18 16 15
         * 20 25 20 19
         * 4 5 2 6 5
         *
         * 7
         * 10 15
         * 18 16 15
         * 20 25 20 19
         * 24 *30* 27 26 24
         *
         * dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j])
         * max = Math.max(dp[i][j],max)
         * 초기값
         */
        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i+1; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
//                    System.out.println("dp[" + i + "][" + j + "] : " + dp[i][j]);
                }
                
            }
        }

        Arrays.sort(dp[N - 1]);
        System.out.println(dp[N - 1][N - 1]);


    }
}
