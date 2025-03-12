import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int testcase = 0; testcase < T; testcase++){
            int answer = 1;

            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 1) + 1);
            }

            for(int num : map.values()){
                answer *= num;
            }

            sb.append(answer-1).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}
