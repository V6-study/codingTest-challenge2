import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new ArrayList[V + 1];
            for(int j = 1;j<V+1;j++){
                graph[j] = new ArrayList<>();
            }
            for(int k = 0; k < E; k++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            System.out.println(checkBipartite(graph,V));

        }

    }

    public static String checkBipartite(List<Integer>[] graph, int V){
        int[] group = new int[V+1];
        // 연결 되지 않은 그래프 처리
        for(int i = 1; i < V+1; i++){
            if(group[i] == 0) {
                if(!BFS(graph,group,i)){
                    return "NO";
                }
            }
        }
        return "YES";
    }


    public static boolean BFS(List<Integer>[] graph,int[] group, int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        group[start]=1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(group[next] == 0){
                    group[next] = -group[now];
                    q.offer(next);
                }else if(group[next] == group[now]){
                    return false;
                }
            }
        }
        return true;
    }
}
