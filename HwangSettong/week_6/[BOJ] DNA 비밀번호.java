//https://www.acmicpc.net/problem/12891
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 문자열 길이
        int p = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        String str = br.readLine();
        String[] temp = br.readLine().split(" ");
        HashMap<Character, Integer> min = new HashMap<>(); // A, C, G, T 최소 개수
        min.put('A', Integer.parseInt(temp[0]));
        min.put('C', Integer.parseInt(temp[1]));
        min.put('G', Integer.parseInt(temp[2]));
        min.put('T', Integer.parseInt(temp[3]));

        HashMap<Character, Integer> cnt = new HashMap<>();
        int start=-1, end=0;
        int answer = 0;
        while(end < s){
            char key = str.charAt(end);
            // 다른 문자가 등장한 경우 해당 위치부터 부분문자열 만들기
            if(!min.containsKey(key)){
                start = end;
                end++;
                cnt.clear();
                continue;
            }
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            if(end - start == p){ // p길이만큼 부분문자열 만들었음
                // 최소 개수 조건을 만족하면 answer+1
                boolean possible = true;
                for(char c: min.keySet()) if(cnt.getOrDefault(c,0) < min.get(c)) possible = false;
                if(possible) answer++;
                // 길이 1만큼 줄이기
                start++;
                char c = str.charAt(start);
                cnt.put(c, cnt.get(c) - 1);
            }
            end++;
        }
        System.out.println(answer);
    }
}
