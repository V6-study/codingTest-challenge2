// https://www.acmicpc.net/problem/1389

import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new List[N+1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        int[] result = new int[N+1];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int num = bfs(i);
            if(min>num)
                min = num;
            result[i] = num;
        }

        for (int i = 1; i <= N; i++) {
            if(min == result[i]){
                sb.append(i);
                break;
            }
        }

        System.out.println(sb);

        br.close();
    }

    static int bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next : adjList[node]){
                if(visited[next])
                    continue;
                dist[next] = dist[node] + 1;
                visited[next] = true;
                q.offer(next);
            }
        }

        return Arrays.stream(dist).sum();
    }
}
