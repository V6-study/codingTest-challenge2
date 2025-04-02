import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr);

        // 산술평균
        sb.append(Math.round(Arrays.stream(arr).sum()/(N*1.0))).append('\n');
        
        // 중앙값
        sb.append(arr[N/2]).append('\n');

        // 최빈값
        int max = map.values().stream().max(((o1, o2) -> o1 - o2)).get();
        List<Integer> list = new ArrayList<>();
        for(int n : map.keySet()){
            if(map.get(n) == max)
                list.add(n);
        }

        Collections.sort(list);

        if(list.size()>1){
            sb.append(list.get(1));
        }else{
            sb.append(list.get(0));
        }
        sb.append('\n');

        // 범위
        sb.append(arr[N-1] - arr[0]).append('\n');

        System.out.println(sb);

        br.close();
    }
}
