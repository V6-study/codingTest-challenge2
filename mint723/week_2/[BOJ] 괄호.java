import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean flag = true;

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(')
                    stack.add('(');
                else {
                    if(stack.isEmpty())
                        flag = false;
                    else{
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty())
                flag = false;

            if(!flag)
                sb.append("NO").append('\n');
            else
                sb.append("YES").append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}
