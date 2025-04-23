//https://www.acmicpc.net/problem/1004
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        StringTokenizer st;
        while(T-->0){
            int circleS = 0, circleE = 0; // 출발지를 포함한 행성 수, 도착지를 포함한 행성 수
            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 출발지
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 도착지
            int n = Integer.parseInt(br.readLine()); // 행성 개수
            while(n-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 행성 중심 x좌표
                int y = Integer.parseInt(st.nextToken()); // 행성 중심 y좌표
                int r = Integer.parseInt(st.nextToken()); // 행성 반지름

                boolean containS = Math.pow(start[0]-x, 2) + Math.pow(start[1]-y, 2) <= Math.pow(r, 2); // 출발지를 포함하는가?
                boolean containE = Math.pow(end[0]-x, 2) + Math.pow(end[1]-y, 2) <= Math.pow(r, 2); // 도착지를 포함하는가?

                if(containS && containE) continue;
                if(containS) circleS++;
                if(containE) circleE++;
            }
            System.out.println(circleS+circleE);
        }
    }
}
