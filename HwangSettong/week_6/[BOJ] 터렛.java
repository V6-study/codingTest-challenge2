//https://www.acmicpc.net/problem/1002
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        StringTokenizer st;
        int x1, y1, r1, x2, y2, r2;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            System.out.println(countPosition(x1,y1, r1, x2, y2, r2));
        }
    }

    static int countPosition(int x1, int y1, int r1, int x2, int y2, int r2) {
        if(x1==x2 && y1==y2 && r1==r2) return -1; // 두 원이 겹치면 return -1
        double distance = Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2)); // 두 원점의 거리
        // 두 원점이 서로의 원 밖에 있는 경우
        if(distance > r1 && distance > r2){
            if(distance == r1+r2) return 1; // 외접하는 경우
            if(distance > r1+r2) return 0; // 두 원이 멀리 떨어져 있는 경우
        }
        if(distance + r1 == r2 || distance + r2 == r1 ) return 1; // 내접하는 경우
        if(distance + Math.min(r1, r2) < Math.max(r1, r2)) return 0; // 한 원이 다른 원 안에 있는 경우
        else return 2; // 두 교점이 있는 경우
    }
}
