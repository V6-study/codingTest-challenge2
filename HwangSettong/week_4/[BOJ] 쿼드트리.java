//https://www.acmicpc.net/problem/1992
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder qt = new StringBuilder();
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        quadTree(0, 0, N);
        String res = qt.toString();
        while(res.indexOf("(1111)") != -1|| res.indexOf("(0000)") != -1 ){
            res = res.replaceAll("\\(1111\\)","1");
            res = res.replaceAll("\\(0000\\)","0");
        }
        System.out.println(res);
    }
  
    static void quadTree(int x, int y, int n){
        if(n==1){
            qt.append(arr[x][y]);
            return;
        }
        qt.append("(");
        quadTree(x, y, n/2);
        quadTree(x, y+n/2, n/2);
        quadTree(x+n/2, y, n/2);
        quadTree(x+n/2, y+n/2, n/2);
        qt.append(")");
    }
}
