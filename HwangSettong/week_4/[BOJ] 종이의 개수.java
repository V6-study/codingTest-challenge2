// https://www.acmicpc.net/problem/1780
import java.io.*;
import java.util.*;

public class Main {
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) arr[i][j] = 2;
            }
        }
        daq(arr, N);
        System.out.println(cnt[2]);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);

    }

    static void daq(int[][] arr, int n){
        if(n == 1){
            if(arr[0][0] != -1) cnt[arr[0][0]]++;
            return;
        }
        int[][] next = new int[n/3][n/3];
        int[] temp = new int[3];
        for(int x=0; x<n/3; x++){
            for(int y=0; y<n/3; y++){
                Arrays.fill(temp, 0);
                for(int i = x*3; i<x*3+3; i++){
                    for(int j = y*3; j<y*3+3; j++){
                        if(arr[i][j] != -1)temp[arr[i][j]]++;
                    }
                }
                for(int i=0; i<3; i++) if(temp[i] == 9) next[x][y] = i;
                if(temp[0] != 9 && temp[1] != 9 && temp[2] != 9) {
                    next[x][y] = -1;
                    cnt[0]+=temp[0];
                    cnt[1]+=temp[1];
                    cnt[2]+=temp[2];
                }
            }
        }
        daq(next, n/3);
    }
}
