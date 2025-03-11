// https://www.acmicpc.net/problem/1541
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] tokens = s.split("(?=[-+])");
        int answer = Integer.parseInt(tokens[0]);

        boolean flag = false;

        for (int i = 1; i < tokens.length; i++) {
            if(tokens[i].charAt(0)=='-')
                flag = true;

            int num = Integer.parseInt(tokens[i].substring(1));
            if(flag){
                answer -= num;
            }else{
                answer += num;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
