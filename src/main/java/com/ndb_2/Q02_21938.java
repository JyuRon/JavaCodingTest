package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q02_21938 {
    static FastReader sc = new FastReader();
    static int N,M, T;
    static int[][] graph;
    static boolean[][] visited;
    static int[][][] pixel;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        pixel = new int[N+1][M+1][3];

        for (int i = 1; i <= N ;i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 3; k++) {
                    pixel[i][j][k] = sc.nextInt();
                }
            }
        }

        T = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int tmp = 0;
                for (int k = 0; k < 3; k++) {
                    tmp += pixel[i][j][k];
                }

                if(tmp / 3  >= T){
                    graph[i][j] = 1;
                }
            }
        }
    }
    static void func(){
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(graph[i][j] == 1 && !visited[i][j]){
                    ans++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(ans);
    }
    static void bfs(int x, int y){
        Queue<Integer>  Q = new LinkedList<>();
        Q.add(x); Q.add(y);
        visited[x][y] = true;
        while (!Q.isEmpty()){
            int currentX = Q.poll();
            int currentY = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dir[i][0];
                int nextY = currentY + dir[i][1];

                // 범위를 벗어나는 경우
                if(nextX > N || nextX <= 0 || nextY > M || nextY <= 0){
                    continue;
                }

                // 물건이 아닌 경우
                if(graph[nextX][nextY] != 1){
                    continue;
                }

                // 이미 방문 이력이 존재하는 경우
                if(visited[nextX][nextY]){
                    continue;
                }

                Q.add(nextX); Q.add(nextY);
                visited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) {
        input();
        func();
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
