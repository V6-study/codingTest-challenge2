import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] x = new long[N];
        long[] y = new long[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long sum1 = 0;
        long sum2 = 0;

        for(int i=0; i<N-1; i++){
            sum1 += x[i] * y[i+1];
            sum2 += x[i+1] * y[i];
        }

        sum1 += x[N-1] * y[0];
        sum2 += x[0] * y[N-1];

        double area = Math.abs(sum1 - sum2) / 2.0;

        System.out.printf("%.1f", area);

        br.close();
    }
}
