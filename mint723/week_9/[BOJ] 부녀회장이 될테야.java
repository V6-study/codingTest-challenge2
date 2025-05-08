import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][15];

        for(int i=0; i<15; i++){
            dp[0][i] = i;
        }

        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int TESTCASE = 0; TESTCASE < T; TESTCASE++) {

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[n][k]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
