import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long N, P, Q;
    static Map<Long, Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        /**
         * ⌊x⌋는 x를 넘지 않는 가장 큰 정수이다.
         * A0 = 1
         * Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
         * A1 = A⌊1/2⌋ + A⌊1/3⌋ (N=7,P=2,Q=3)
         *    = 1 + 1 = 2
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        dp.put(0L, 1L);
        System.out.println(dfs(N));

    }
    public static long dfs (long i) {
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        long value = dfs(i/P) + dfs(i/Q);
        dp.put(i, value);
        return value;
    }
}
