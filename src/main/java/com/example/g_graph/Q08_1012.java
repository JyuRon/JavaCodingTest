package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class Q08_1012 {

    static FastReader sc = new FastReader();
    static int testCase;
    static int N, M, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            graph[row][col] = 1;
        }
    }

    static void func(){
        int result = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i,j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int row, int col){
        Queue<Integer> Q = new LinkedList<>();
        visited[row][col] = true;

        Q.add(row);
        Q.add(col);

        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dir[i][0];
                int nextCol = currentCol + dir[i][1];

                // 영역 밖에 존재하는 경우
                if(nextRow < 0 || nextCol < 0 || nextRow > N || nextCol > M){
                    continue;
                }

                // 이미 방문한 이력이 있는 경우
                if(visited[nextRow][nextCol]){
                    continue;
                }

                // 이동이 불가능한 경우
                if(graph[nextRow][nextCol] == 0){
                    continue;
                }

                Q.add(nextRow);
                Q.add(nextCol);
                visited[nextRow][nextCol] = true;
            }
        }

    }

    public static void main(String[] args) {
        testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
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
