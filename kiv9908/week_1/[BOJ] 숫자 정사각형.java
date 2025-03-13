import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxSize = 1; // 최소 크기는 1x1
        int maxSidelen = Math.min(N, M); // 가능한 최대 변의 길이

        // 변의 길이를 1부터 최대 길이까지 검사
        for (int len = 1; len <= maxSidelen; len++) {
            if (isEqualConer(N, M, len)) {
                maxSize = len;
            }
        }

        // 넓이는 한 변의 길이의 제곱
        System.out.println(maxSize * maxSize);
    }

    public static boolean isEqualConer(int N, int M, int size) {
        // 변의 길이가 size인 정사각형을 찾음
        for (int i = 0; i <= N - size; i++) {
            for (int j = 0; j <= M - size; j++) {
                // 네 꼭짓점의 값이 같은지 확인
                int value = arr[i][j];
                if (value == arr[i][j + size - 1] &&
                        value == arr[i + size - 1][j] &&
                        value == arr[i + size - 1][j + size - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
