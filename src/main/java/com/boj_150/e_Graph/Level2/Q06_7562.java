package com.boj_150.e_Graph.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q06_7562 {
    static FastReader sc = new FastReader();
    static int T, N, startX, startY, endX, endY;
    static int[][] graph, dir = {{-2, -1},{-1, -2},{1,-2},{2,-1},{1,2},{2,1},{-2,1},{-1,2}};
    static int[][] distance;

    static void input(){
        N = sc.nextInt();
        graph = new int[N][N];
        distance = new int[N][N];

        startX = sc.nextInt();
        startY = sc.nextInt();

        endX = sc.nextInt();
        endY = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(startX, startY);
    }

    static void bfs(int x, int y){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); Q.add(y);
        distance[x][y] = 0;

        while (!Q.isEmpty()){
            int currentX = Q.poll();
            int currentY = Q.poll();

            if(currentX == endX && currentY == endY){
                System.out.println(distance[currentX][currentY]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dir[i][0];
                int nextY = currentY + dir[i][1];

                // 범위를 벗어나는 경우
                if(nextX >= N || nextY >= N || nextX < 0 || nextY < 0) continue;

                // 이미 방문한 이력이 있는 경우
                if(distance[nextX][nextY] != Integer.MAX_VALUE) continue;


                distance[nextX][nextY] = distance[currentX][currentY] + 1;
                Q.add(nextX); Q.add(nextY);
            }
        }

    }

    public static void main(String[] args) {
        T = sc.nextInt();
        while (T-- > 0){
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
