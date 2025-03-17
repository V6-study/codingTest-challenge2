import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 1;
        Map<String, String> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(String.valueOf(num), name);
            map.put(name, String.valueOf(num++));
        }

        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
