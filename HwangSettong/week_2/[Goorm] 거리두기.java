// https://level.goorm.io/exam/160279/%EA%B1%B0%EB%A6%AC%EB%91%90%EA%B8%B0/quiz/1
import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[n][5];
		Arrays.fill(arr[0], 1);
		for(int i=1; i<n; i++){
			arr[i][0] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2] + arr[i-1][3] + arr[i-1][4])%100000007;
			arr[i][1] = (arr[i-1][0] + arr[i-1][2] + arr[i-1][4])%100000007;
			arr[i][2] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][4])%100000007;
			arr[i][3] = (arr[i-1][0] + arr[i-1][4])%100000007;
			arr[i][4] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2] + arr[i-1][3])%100000007;
		}
		
		System.out.println((Arrays.stream(arr[n-1]).sum())%100000007);
	}
}
/*
이전 테이블 배열
0: XXX -> 0, 1, 2, 3, 4 올 수 있음
1: OXX -> 0, 2, 4 올 수 있음
2: XXO -> 0, 1, 4 올 수 있음
3: OXO -> 0, 4 올 수 있음
4: XOX -> 0, 1, 2, 3 올 수 있음
*/
