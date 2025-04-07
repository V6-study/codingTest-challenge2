import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
				int[][] dp = new int[N+1][K+1];

        for (int k = 1; k <= K; k++) {
            dp[0][k] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                dp[n][k] = (dp[n][k - 1] + dp[n - 1][k]) % 1_000_000_000;
            }
        }

        System.out.println(dp[N][K]);


    }
}
