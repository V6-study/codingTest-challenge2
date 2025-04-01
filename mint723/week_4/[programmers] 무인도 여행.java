import java.util.*;

class Solution {
    int N, M;
    boolean[][] visited;
    String[] maps;
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,1,-1};
    
    public List<Integer> solution(String[] maps) {
        this.maps = maps;
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || maps[i].charAt(j) == 'X')
                    continue;
                list.add(dfs(new int[]{i,j,maps[i].charAt(j)-'0'}));
            }
        }
        if(list.isEmpty())
            list.add(-1);
        
        list.sort((o1, o2) -> o1-o2);
        
        return list;
    }
    
    int dfs(int[] info){
        int y = info[0];
        int x = info[1];
        int score = maps[y].charAt(x) - '0';
        
        visited[y][x] = true;
        
        for(int i=0; i<4; i++){
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            
            if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                score += dfs(new int[]{ny, nx});
            }
        }
        
        return score;
    }
}
