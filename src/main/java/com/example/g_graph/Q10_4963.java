package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 */
public class Q10_4963 {

    static FastReader sc = new FastReader();
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

    static void input(){
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
    }

    static void func(){
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i,j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int i, int j){
        Queue<Integer> Q = new LinkedList<>();
        visited[i][j] = true;
        Q.add(i);Q.add(j);

        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();

            for (int k = 0; k < 8; k++) {
                int nextRow = currentRow + dir[k][0];
                int nextCol = currentCol + dir[k][1];

                // 지도 범위 밖인 경우
                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M){
                    continue;
                }

                // 이미 방문한 경우
                if(visited[nextRow][nextCol]){
                    continue;
                }

                // 방문 불가 지역인 경우
                if(graph[nextRow][nextCol] == 0){
                    continue;
                }

                visited[nextRow][nextCol] = true;
                Q.add(nextRow);
                Q.add(nextCol);
            }


        }
    }

    public static void main(String[] args) {
        while (true){
            M = sc.nextInt();
            N = sc.nextInt();

            if(N == 0 && M == 0){
                break;
            }

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
