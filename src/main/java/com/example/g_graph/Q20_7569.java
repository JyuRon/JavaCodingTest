package com.example.g_graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7569
 */
public class Q20_7569 {

    static FastReader sc = new FastReader();
    static int N,M,H;
    static int[][][] distance;
    static int[][][] graph;
    static boolean check = false;
    static int[][] dir = {{-1,0,0}, {1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};

    static void input(){
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        graph = new int[N][M][H];
        distance = new int[N][M][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    graph[j][k][i] = sc.nextInt();
                    distance[j][k][i] = -1;
                }
            }
        }
    }


    static void func(){
        Queue<Integer> Q = new LinkedList<>();


        // 익은 토마토를 큐에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if(distance[i][j][k] == -1 && graph[i][j][k] == 1){
                        distance[i][j][k] = 0;
                        Q.add(i);Q.add(j);Q.add(k);
                    }
                }
            }
        }

        // bfs 시작
        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();
            int currentHeight = Q.poll();

            for (int i = 0; i < 6; i++) {
                int nextRow = currentRow + dir[i][0];
                int nextCol = currentCol + dir[i][1];
                int nextHeight = currentHeight + dir[i][2];

                // 영역을 벗어나는 경우
                if(nextRow < 0 || nextCol < 0 || nextHeight < 0 || nextRow >= N || nextCol >= M || nextHeight >= H){
                    continue;
                }

                // 이미 방문한 이력이 존재하는 경우
                if(distance[nextRow][nextCol][nextHeight] != -1){
                    continue;
                }

                // 이동하지 못하는 경우
                if(graph[nextRow][nextCol][nextHeight] != 0){
                    continue;
                }

                distance[nextRow][nextCol][nextHeight] = distance[currentRow][currentCol][currentHeight] + 1;
                Q.add(nextRow);
                Q.add(nextCol);
                Q.add(nextHeight);
            }
        }


        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    int checkValue = distance[i][j][k];

                    result = Math.max(result, checkValue);

                    if(checkValue == -1 && graph[i][j][k] == 0){
                        result = -1;
                        break;
                    }
                }
                if(result == -1){
                    break;
                }
            }
            if(result == -1){
                break;
            }
        }

        System.out.println(result);

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
