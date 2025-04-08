//https://www.acmicpc.net/problem/16918
import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        String[][] origin = new String[R][C];
        for (int r = 0; r < R; r++) origin[r] = br.readLine().split("");
        String[][][] arr = new String[4][R][C];
        for(int i = 0; i<3; i++) for(int r = 0; r < R; r++) Arrays.fill(arr[i][r], "O");
        for(int r = 0; r < R; r++) for(int c=0; c < C; c++) if (origin[r][c].equals("O")) bomb(arr[1], r, c);
        for(int r = 0; r < R; r++) for(int c=0; c < C; c++) if (arr[1][r][c].equals("O")) bomb(arr[2], r, c);


        if(N == 1) Arrays.stream(origin).forEach(i->System.out.println(String.join("", i)));
        else if(N % 2 == 0) Arrays.stream(arr[0]).forEach(i->System.out.println(String.join("", i)));
        else if(N % 4 == 3) Arrays.stream(arr[1]).forEach(i->System.out.println(String.join("", i)));
        else if(N % 4 == 1) Arrays.stream(arr[2]).forEach(i->System.out.println(String.join("", i)));
    }


    static void bomb(String[][] arr, int r, int c){
        arr[r][c] = ".";   // (r,c)
        arr[Math.max(0,r-1)][c] = ".";   // 상
        arr[Math.min(R-1,r+1)][c] = "."; // 하
        arr[r][Math.max(0,c-1)] = ".";   // 좌
        arr[r][Math.min(C-1,c+1)] = "."; // 우
    }
}
