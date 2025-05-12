import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            if(!list.contains(s))
                list.add(s);
        }

        list.sort((o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for(String s : list){
            sb.append(s).append('\n');
        }

        System.out.println(sb);

    }
}
