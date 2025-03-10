// https://level.goorm.io/exam/353639/%EA%B5%AC%EB%A6%84%EC%9D%B4%EC%9D%98-%EC%A7%91%EC%A7%93%EA%B8%B0-%EA%B3%84%ED%9A%8D/quiz/1
import java.io.*;
class Main {
	static int n, k;
	static int[] profits;
	static int maxProfit;
	static void dfs(int cnt, int idx, int profit){
		if(idx == n-1){
			if(cnt < k && profit + profits[idx] > maxProfit)  maxProfit = profit + profits[idx];
			else if(profit > maxProfit) maxProfit = profit;
			return;
		}
		if(cnt < k) dfs(cnt+1, idx+1, profit + profits[idx]);
		dfs(0, idx+1, profit);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input.split(" ")[0]);
		k = Integer.parseInt(input.split(" ")[1]);
		profits = new int[n];
		for(int i=0; i<n; i++){
			profits[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0,0);
		System.out.println(maxProfit);
	}
}
