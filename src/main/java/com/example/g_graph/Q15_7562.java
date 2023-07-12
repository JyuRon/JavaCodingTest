package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7562
 */
public class Q15_7562 {

    static FastReader sc = new FastReader();
    static int testCase, N;
    static int[][] distance, graph;
    static boolean[][] visited;
    static int knightRow, knightCol;
    static int dRow, dCol;
    static int[][] dir = {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};

    static void input(){
        N = sc.nextInt();
        graph = new int[N][N];
        distance = new int[N][N];
        visited = new boolean[N][N];

        knightRow = sc.nextInt();
        knightCol = sc.nextInt();

        dRow = sc.nextInt();
        dCol = sc.nextInt();
    }

    static void func(){

        Queue<Integer> Q = new LinkedList<>();
        Q.add(knightRow);
        Q.add(knightCol);
        visited[knightRow][knightCol] = true;
        distance[knightRow][knightCol] = 0;

        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nextRow = currentRow + dir[i][0];
                int nextCol = currentCol + dir[i][1];

                // 지도 범위를 벗어나는 경우
                if(nextCol < 0 || nextRow < 0 || nextRow >= N || nextCol >= N){
                    continue;
                }

                // 이미 방문한 경우
                if(visited[nextRow][nextCol]){
                    continue;
                }

                Q.add(nextRow);
                Q.add(nextCol);

                visited[nextRow][nextCol] = true;
                distance[nextRow][nextCol] = distance[currentRow][currentCol] + 1;
            }
        }
        System.out.println(distance[dRow][dCol]);
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
            while (st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
