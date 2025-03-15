import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static char[] eq;
    static boolean[] visited = new boolean[10]; // 숫자 사용 여부 체크
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 부등호 개수
        eq = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            eq[i] = st.nextToken().charAt(0); // 부등호 입력
        }

        // 0~9 숫자 중 하나씩 선택해 DFS 시작
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(0, i, String.valueOf(i)); // 깊이 0부터 시작
            visited[i] = false;
        }

        // 결과 리스트 정렬 후 출력 (최소, 최대)
        Collections.sort(results);
        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }

    // depth: 현재 단계, num: 현재까지 만든 숫자 문자열
    public static void dfs(int depth, int prev, String num) {
        if (depth == K) { // 모든 자리 선택 완료
            results.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                // 부등호 조건 체크
                if ((eq[depth] == '<' && prev < i) || (eq[depth] == '>' && prev > i)) {
                    visited[i] = true;
                    dfs(depth + 1, i, num + i);
                    visited[i] = false;
                }
            }
        }
    }
}
