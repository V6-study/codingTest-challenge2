import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bread(A, B);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }


    public static void bread(int A, int B) {
        if(A == 0 || A<=B){
            answer = Math.min(answer, B);
        }else if(A>B){
            answer = Math.min(answer, Integer.MAX_VALUE);
        }
    }
}
