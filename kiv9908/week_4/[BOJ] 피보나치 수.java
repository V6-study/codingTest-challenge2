import java.io.*;

public class Main {

    static int[] zeroCnt = new int[41];
    static int[] oneCnt = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 미리 모든 fibo 계산해서 저장
        zeroCnt[0] = 1;  // fibonacci(0) 호출 시
        oneCnt[1] = 1;   // fibonacci(1) 호출 시

        for (int i = 2; i <= 40; i++) {
            zeroCnt[i] = zeroCnt[i - 1] + zeroCnt[i - 2];
            oneCnt[i] = oneCnt[i - 1] + oneCnt[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(zeroCnt[n] + " " + oneCnt[n]);
        }
    }
}
