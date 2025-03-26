import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        char oddChar = ' ';

        StringBuilder half = new StringBuilder();

        for (char c : map.keySet()) {
            int count = map.get(c);

            if (count % 2 != 0) {
                oddCount++;
                oddChar = c;
            }

            if (oddCount > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            for (int i = 0; i < count / 2; i++) {
                half.append(c);
            }
        }

        StringBuilder result = new StringBuilder(half);

        if (oddCount == 1) {
            result.append(oddChar);
        }

        result.append(new StringBuilder(half).reverse());

        System.out.println(result);

        br.close();
    }
}
