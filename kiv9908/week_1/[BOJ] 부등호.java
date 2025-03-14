import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2529 {
    static int k;
    static char[] eq;
    static long min = Long.MAX_VALUE;
    static long max = 0;
    static String minStr = "";
    static String maxStr = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        eq = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            eq[i] = st.nextToken().charAt(0);
        }

        for (int n = 0; n <= 9; n++) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n);
            dfs(n, 0, arr);
        }
        System.out.println(maxStr + "\n" + minStr);
    }

    public static void dfs(int n, int idx, ArrayList<Integer> arr) {
        if (idx == k) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num);
            }
            long result = Long.parseLong(sb.toString());
            min = Math.min(min, result);
            minStr = min == result ? sb.toString() : minStr;
            max = Math.max(max, result);
            maxStr = max == result ? sb.toString() : maxStr;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (arr.contains(i)) continue;
            if (eq[idx] == '>' && n < i) continue;
            if (eq[idx] == '<' && n > i) continue;
            arr.add(i);
            dfs(i, idx + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }
}
