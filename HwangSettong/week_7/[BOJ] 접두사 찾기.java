//https://www.acmicpc.net/problem/14426
import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        char item;
        HashMap<Character, Node> children;
        Node(char item){
            this.item = item;
            this.children = new HashMap<>();
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);
        Node root = new Node(' ');
        // 각 문자열의 문자 순서로 트리 만들기
        while(N-->0) {
            s = br.readLine();
            HashMap<Character, Node> cur = root.children;
            for(int i = 0; i<s.length(); i++){
                if(! cur.containsKey(s.charAt(i))) cur.put(s.charAt(i), new Node(s.charAt(i)));
                cur = cur.get(s.charAt(i)).children;
            }
        }
        // 트리 탐색. 끊기면 접두사 X
        int answer = 0;
        while(M-->0) {
            s = br.readLine();
            boolean isPrefix = true;
            HashMap<Character, Node> cur = root.children;
            for(int i = 0; i<s.length(); i++){
                if(! cur.containsKey(s.charAt(i))) {
                    isPrefix = false;
                    break;
                }
                cur = cur.get(s.charAt(i)).children;
            }
            if(isPrefix) answer++;
        }
        System.out.println(answer);
    }
}
