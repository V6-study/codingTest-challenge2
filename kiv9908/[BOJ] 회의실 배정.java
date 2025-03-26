import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
     * 회의실 배정 = 우선순위 큐에 넣음
     * peek 한 값이 현재 비교 값의 start보다 작으면 (이미 종료) 회의실 배정
     * 마지막에 size return
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        List<int[]> rooms = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new int[]{start, end});
        }
        // start 기준 오름차순 정렬
        rooms.sort((o1, o2) -> o1[0] - o2[0]);
        pq.add(rooms.get(0)[1]);
        for (int i = 1; i < rooms.size(); i++) {
            if (!pq.isEmpty()) {
                if (pq.peek() <= rooms.get(i)[0]) {
                    pq.poll();
                    pq.add(rooms.get(i)[1]);
                }else {
                    pq.add(rooms.get(i)[1]);
                }
            }
        }
        System.out.println(pq.size());
    }
}
