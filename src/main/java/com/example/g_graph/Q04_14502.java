package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14502
 */
public class Q04_14502 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
    }

    static void func(){
        makeWall(0,0,0);
        Collections.sort(result);
        System.out.println(result.get(result.size()-1));

    }

    static void countVirus(){

        // 바이러스 위치를 판단하여 방문하지 않는 경우 dfs 탐색을 실시한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 2 && !visited[i][j]){
                    dfs(i,j);
                }
            }
        }

        // 바이러스 방문 기록이 생겼으니 이를 이용하여 안전 지대를 파악한다.
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0 && !visited[i][j]){
                    count++;
                }
            }
        }

        result.add(count);
    }

    static void dfs(int i, int j){
        visited[i][j] = true;


        for (int k = 0; k < 4; k++) {
            int nextRow = i + dir[k][0];
            int nextCol = j + dir[k][1];

            // 행렬 범위를 벗어나는 경우
            if(nextRow < 0 || nextCol < 0 || nextRow >=N || nextCol >= M){
                continue;
            }

            // 이미 방문한 이력이 존재하는 겨웅
            if(visited[nextRow][nextCol]){
                continue;
            }

            // 벽인 경우
            if(graph[nextRow][nextCol] == 1){
                continue;
            }

            dfs(nextRow, nextCol);
        }
    }

    static void makeWall(int row, int col, int cnt){
        if(cnt == 3){
            visited = new boolean[N][M];
            countVirus();
            return;
        }

        // 열에 대해서는 미리 mod 를 통해 검사
        if(row >= N){
            return;
        }

        // 다음 이동할 위치를 지정
        int nextRow, nextCol;

        if( col + 1 == M ){
            nextCol = 0;
            nextRow = row + 1;
        }else{
            nextCol = col + 1;
            nextRow = row;
        }

        if(graph[row][col] == 0){

            // 벽을 하나 채운 경우
            graph[row][col] = 1;
            makeWall(nextRow, nextCol, cnt+1);

            // 벽을 세우지 않는 경우
            graph[row][col] = 0;
            makeWall(nextRow, nextCol, cnt);

        }else{
            // 벽이거나 바이러스인 경우 다음으로 넘긴다.
            makeWall(nextRow, nextCol, cnt);
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
