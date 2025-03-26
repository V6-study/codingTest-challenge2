import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<int[]> ranks = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            int passCnt = 1;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int[] rank = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                ranks.add(rank);
            }
            // 서류 기준 오름차순
            Collections.sort(ranks, (o1, o2) -> o1[0] - o2[0]);
            // 1등 면접 성적 추출
            int maxInterviewRank = ranks.get(0)[1];
            for (int k = 1; k < ranks.size(); k++) {
                if(ranks.get(k)[1] < maxInterviewRank) {
                    maxInterviewRank = ranks.get(k)[1];
                    passCnt++;
                }
            }
            System.out.println(passCnt);
        }
    }
}
