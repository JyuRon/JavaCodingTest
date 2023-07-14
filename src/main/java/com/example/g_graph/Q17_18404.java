package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18404
 */
public class Q17_18404 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N, targetCount, startNodeRow, startNodeCol;
    static int[][] visited;
    static int[] target;
    static int[][] dir = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

    static void input(){
        N = sc.nextInt();
        targetCount = sc.nextInt();

        visited = new int[N+1][N+1];
        target = new int[targetCount*2];

        startNodeRow = sc.nextInt();
        startNodeCol = sc.nextInt();

        for (int i = 0; i < targetCount; i++) {
            target[i*2] = sc.nextInt();
            target[i*2 + 1] = sc.nextInt();
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                visited[i][j] = -1;
            }
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(startNodeRow);
        Q.add(startNodeCol);
        visited[startNodeRow][startNodeCol] = 0;

        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nextRow = currentRow + dir[i][0];
                int nextCol = currentCol + dir[i][1];

                // 영역을 벗어나는 경우
                if(nextCol <= 0 || nextRow <= 0 || nextCol > N || nextRow > N){
                    continue;
                }

                // 이미 방문한 이력이 있는 경우
                if(visited[nextRow][nextCol] != -1){
                    continue;
                }

                visited[nextRow][nextCol] = visited[currentRow][currentCol] + 1;
                Q.add(nextRow);
                Q.add(nextCol);
            }
        }

        for (int i = 0; i < targetCount; i++) {
            sb.append(visited[target[i*2]][target[i*2 +1]]).append(" ");
        }

        System.out.println(sb.toString());
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
