//https://www.acmicpc.net/problem/1654
import java.io.*;
import java.util.*;

public class Main {
    static int K, N; // K:갖고있는 랜선 수, N:필요한 랜선 수
    static long[] arr; // 갖고있는 랜선 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) arr[i] = Long.parseLong(br.readLine());
        
        Arrays.sort(arr);

        System.out.println(binarySearch(1, arr[K - 1]));
    }

    static long binarySearch(long min, long max) {
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (long len : arr) {
                cnt += len / mid;
            }

            if (cnt >= N) { // mid 길이 가능하면 랜선 길이 더 늘리기
                answer = mid;
                min = mid + 1;
            } else { // mid 길이 불가능하면 랜선 길이 더 줄이기
                max = mid - 1;
            }
        }
        return answer;
    }
}
