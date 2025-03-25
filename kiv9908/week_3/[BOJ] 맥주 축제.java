import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마셔야 할 맥주 수
        long M = Long.parseLong(st.nextToken());  // 필요한 최소 선호도 합
        int K = Integer.parseInt(st.nextToken()); // 전체 맥주 수

        List<int[]> beers = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 선호도
            int c = Integer.parseInt(st.nextToken()); // 도수레벨
            beers.add(new int[]{v, c});
        }

        // 도수레벨 기준 정렬
        beers.sort(Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        int answer = -1;

        for (int[] beer : beers) {
            pq.add(beer[0]);
            sum += beer[0];

            if (pq.size() > N) {
                sum -= pq.poll(); // 가장 낮은 선호도 제거
            }

            if (pq.size() == N && sum >= M) {
                answer = beer[1]; // 현재 도수레벨이 가장 낮은 최대값이 됨
                break; // 더 좋은 조합이 없으므로 바로 종료
            }
        }

        System.out.println(answer);
    }
}
