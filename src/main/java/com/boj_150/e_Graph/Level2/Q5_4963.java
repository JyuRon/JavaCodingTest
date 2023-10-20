package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q5_4963 {
    static FastReader sc = new FastReader();
    static int  M, N;
    static int[][] map, dir =  {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static boolean[][] visited;

    static void input(){
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    result++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int a = x + dir[i][0];
            int b = y + dir[i][1];

            // 범위를 벗어나는 경우
            if(a >= N || a < 0 || b >= M || b < 0){
                continue;
            }

            // 이미 방문한 경우
            if(visited[a][b]) continue;

            // 바다인 경우
            if(map[a][b] == 0) continue;;

            dfs(a,b);
        }
    }

    public static void main(String[] args) {
        while (true){
            M = sc.nextInt();
            N = sc.nextInt();

            if(N == 0 && M == 0){
                return;
            }

            input();

        }
    }
    static class FastReader{
            BufferedReader br;
            StringTokenizer st;

            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public String next(){
                try{
                    while (st == null || !st.hasMoreElements()){
                        st = new StringTokenizer(br.readLine());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

                return st.nextToken();
            }

            public int nextInt(){
                return Integer.parseInt(next());
            }
        }
}
