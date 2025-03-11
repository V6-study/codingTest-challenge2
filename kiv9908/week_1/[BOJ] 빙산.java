package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2573_빙산 {
    /*
        1. 배열 저장하기
        2. 방문 배열 만들기(일회성), year 변수 만들기
        3. bfs 로직 구현하기
            - 해당 칸이 0이 아닌 경우, 상하좌우 탐색 하면서 0의 개수를 해당 칸에서 빼기
            - 뺐는데 0보다 작아지는 경우 0으로 입력
         4. isTwo
            - 두개인지 확인하는 로직 return boolean
            - false면 bfs 한번 더
            - true이면 year 출력
     */
    
    static int N;
    static int M;
    static int[][] arr;
    static int year;
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
    }
}
