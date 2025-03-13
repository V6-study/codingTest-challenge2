import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i=start; i<=end; i++){
            if(isPrime(i))
                sb.append(i).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    static boolean isPrime(int n){
        if(n<2)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return false;
        for(int i=3; i<=Math.sqrt(n); i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
