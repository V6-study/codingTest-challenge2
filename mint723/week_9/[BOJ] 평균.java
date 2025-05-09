import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] scores = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < num; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        double sum = 0;
        for (int i = 0; i < num; i++) {
            sum += (double) scores[i] / max * 100;
        }

        System.out.println(sum / num);
    }
}
