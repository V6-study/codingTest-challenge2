//https://www.acmicpc.net/problem/17829
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(pooling(arr, N));

    }

    static int pooling(int[][] arr, int n){
        if(n == 1) return arr[0][0];
        int[][] next = new int[n/2][n/2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int x = 0; x<n/2; x++){
            for(int y = 0; y<n/2; y++){
                pq.clear();
                pq.offer(arr[x*2][y*2]);
                pq.offer(arr[x*2][y*2+1]);
                pq.offer(arr[x*2+1][y*2]);
                pq.offer(arr[x*2+1][y*2+1]);
                pq.poll();
                next[x][y] = pq.poll();
            }
        }
        return pooling(next, n/2);
    }
}
