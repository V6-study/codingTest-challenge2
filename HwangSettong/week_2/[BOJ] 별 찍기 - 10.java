// https://www.acmicpc.net/problem/2447

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        print(divideAndConquer(N));
    }

    static String[] divideAndConquer(int n){
        if(n == 3) return new String[]{"***","* *","***"};
        String[] dac = divideAndConquer(n/3);
        String[] res = new String[n];
        // res 채우기
        for(int i = 0; i < n/3; i++){
            res[i] = dac[i].repeat(3); // 위
            res[i+n/3] = dac[i] + " ".repeat(n/3) + dac[i]; // 중간
            res[i+n/3*2] = dac[i].repeat(3); // 아래
        }
        return res;
    }

    static void print(String[] dac){
        for(String d: dac){
            System.out.println(d);
        }
    }
}
