import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0)
                stack.pop();
            else
                stack.add(num);
        }

        while (!stack.isEmpty()){
            answer+=stack.pop();
        }

        System.out.println(answer);

        br.close();
    }
}
