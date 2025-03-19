//https://www.acmicpc.net/problem/5904
import java.io.*;

public class Main {
    static int[] len = new int[60]; // {0, 3, 10, 25, 56, ...}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // k 구하기
        int k = 0;
        for(int i = 1; i<60; i++){
            len[i] = (len[i-1]*2) + (i+2);
            if(len[i] >= N){
                k = i;
                break;
            }
        }
        System.out.println(divideAndConquer(k, N));

    }
    static String divideAndConquer(int k, int n){
        if( k == -1) return "moo".charAt(n-1) +"";
        if(n <=len[k]) return divideAndConquer(k-1, n);
        else if( n == len[k] + 1) return "m";
        else if( n <= len[k] + k + 3) return "o";
        else return divideAndConquer(k-1, n-(len[k]+k+3));
    }
}
