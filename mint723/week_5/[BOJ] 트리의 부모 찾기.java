import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] adjList = new List[N+1];
        boolean[] visited = new boolean[N+1];
        int[] parents = new int[N+1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        while (!q.isEmpty()){
            int node = q.poll();

            for(int nextNode : adjList[node]){
                if(visited[nextNode])
                    continue;
                visited[nextNode] = true;

                parents[nextNode] = node;
                q.offer(nextNode);
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
