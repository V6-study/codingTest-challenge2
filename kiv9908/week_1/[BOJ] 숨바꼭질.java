import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];

    public static class Node {
        int point;
        int time;
        public Node(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int answer = BFS();
        System.out.println(answer);
    }

    public static int BFS(){
        visited[n] = true;
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if(now.point == k) return now.time;
            int[] newPoint = {now.point + 1, now.point - 1, now.point * 2};
            for(int np : newPoint){
                if(np >= 0 && np < 100001 && !visited[np]){
                    visited[np] = true;
                    q.offer(new Node(np, now.time + 1));
                }
            }

        }

        return -1;

    };
}


