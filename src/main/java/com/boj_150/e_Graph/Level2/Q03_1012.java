package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q03_1012 {
    static FastReader sc = new FastReader();
    static int N,M,K, T;
    static int[][] map, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[x][y] = 1;
        }
    }

    static void func(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);Q.add(y);
        visited[x][y] = true;

        while (!Q.isEmpty()){
            int currentX = Q.poll();
            int currentY = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dir[i][0];
                int nextY = currentY + dir[i][1];

                // 범위를 벗어나는 경우
                if(nextX >= N || nextX < 0 || nextY >= M || nextY < 0){
                    continue;
                }
                // 이미 방문한 이력이 있는 경우
                if(visited[nextX][nextY]) continue;;

                // 방문하지 못하는 경우
                if(map[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                Q.add(nextX); Q.add(nextY);
            }
        }
    }
    public static void main(String[] args) {
        T = sc.nextInt();
        while (T-- > 0){
            input();
            func();
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
