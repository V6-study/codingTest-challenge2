//https://www.acmicpc.net/problem/14888
import java.io.*;
import java.util.*;

public class Main {
    static int n; // 수의 개수
    static int[] nums; // 수열
    static int[] operators; // 덧셈, 뺄셈, 곱셈, 나눗셈 연산자 수
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backtracking(1, nums[0]);
        System.out.print(max+"\n"+min);
    }

    static void backtracking(int idx, int res){
        if(idx == n){
            if(max < res) max = res;
            if(min > res) min = res;
            return;
        }
        int next=0;
        for(int i=0; i<4; i++){
            if(operators[i] <= 0 ) continue;
            operators[i]--;
            if(i==0) next = res + nums[idx];
            else if(i==1) next = res - nums[idx];
            else if(i==2) next = res * nums[idx];
            else if(i==3) next = res / nums[idx];
            backtracking(idx + 1, next);
            operators[i]++;
        }
    }
}
