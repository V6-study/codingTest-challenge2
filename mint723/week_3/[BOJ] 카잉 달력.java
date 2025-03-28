import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int year = x;

            while (year <= M * N) { // 최대 공배수가 넘지 않도록
                if ((year - 1) % N + 1 == y) { // Y와 일치하는 경우
                    break;
                }
                year += M;
            }
            if(year > N*M)
                sb.append(-1).append('\n');
            else
                sb.append(year).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
