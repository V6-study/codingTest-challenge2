//https://www.acmicpc.net/problem/2512
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지방의 수
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 각 지방의 요청 예산
        int M = Integer.parseInt(br.readLine()); // 총 예산

        Arrays.sort(req);

        int answer = 0;
        for(int i = 0; i<N; i++){
            int max = M/(N-i); // 균등 분배를 위한 상한액
            if(req[i] > max){
                answer = max;
                break;
            } else{
                answer = req[i];
                M -= req[i];
            }
        }
        System.out.println(answer);
    }
}
