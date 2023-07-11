package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 */
public class Q05_2178 {
    static FastReader sc = new FastReader();
    static int N,M;
    static String[] graph;
    static int[][] distance;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new String[N];
        distance = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = sc.next();

            for (int j = 0; j < M; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        Q.add(0);
        distance[0][0] = 1;

        while (!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();
            int currentDistance = distance[x][y];

            for (int i = 0; i < 4; i++) {
                int nextRow = x + dir[i][0];
                int nextCol = y + dir[i][1];

                if(nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M && graph[nextRow].charAt(nextCol) == '1'){
                    if(currentDistance + 1 < distance[nextRow][nextCol]){
                        distance[nextRow][nextCol] = currentDistance + 1;
                        Q.add(nextRow);
                        Q.add(nextCol);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        func();
        System.out.println(distance[N-1][M-1]);
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
            }catch(IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
