//https://www.acmicpc.net/problem/2513
import java.io.*;
import java.util.*;

public class Main {
    static int N, K, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 단지 수
        K = Integer.parseInt(st.nextToken()); // 버스 정원
        S = Integer.parseInt(st.nextToken()); // 학교 위치

        ArrayList<int[]> left = new ArrayList<>(); // 학교 왼쪽 [{단지위치, 학생 수},...]
        ArrayList<int[]> right = new ArrayList<>(); // 학교 오른쪽 [{단지위치, 학생 수},...]
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int apt = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if(apt < S) left.add(new int[]{S-apt, cnt});
            else right.add(new int[]{apt-S, cnt});
        }

        left.sort((o1,o2) -> o2[0]-o1[0]); // 오름차순 정렬
        right.sort((o1,o2) -> o2[0]-o1[0]); // 내림차순 정렬

        System.out.println(getDistance(left) + getDistance(right));
    }

    static int getDistance(ArrayList<int[]> apt){
        int dist = 0;
        int cnt = 0;
        for(int i=0; i<apt.size(); i++){
            if(cnt == 0) dist += 2*apt.get(i)[0];
            if(apt.get(i)[1] > K-cnt){
                apt.get(i)[1] -= (K-cnt);
                cnt  = 0;
                i--;
            }else cnt += apt.get(i)[1];
        }
        return dist;
    }
}
