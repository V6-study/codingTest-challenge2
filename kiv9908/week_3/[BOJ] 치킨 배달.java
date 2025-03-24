import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] selected;
    static int[][] arr;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if(value == 1) {
                    home.add(new int[]{i, j});
                }else if (value==2){
                    chicken.add(new int[]{i, j});
                }
            }
        }
        selected = new boolean[chicken.size()];
        combination(0,0);
        System.out.println(min);
    }

    public static void combination(int idx, int depth) {
        if(depth == M){
        // M개 만큼의 조합을 찾으면, M 별 도시의 치킨 거리(치킨 거리의 합)을 구한다.
            int total = 0;
            for(int i = 0;i<home.size();i++){
                int dist = Integer.MAX_VALUE;
                for(int j = 0;j<chicken.size();j++){
                    if (selected[j]) {
                        int[] now = chicken.get(j);
                        dist = Math.min(dist,Math.abs(home.get(i)[0]-now[0])+Math.abs(home.get(i)[1]-now[1]));
                    }
                }
                total += dist;
            }
            min = Math.min(min,total);
            return;

        }

        for(int i = idx; i<chicken.size(); i++){
            selected[i] = true; // 선택!
            combination(i+1, depth+1);
            selected[i] = false;
        }
    }

}
