package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22255
 */
public class Q_3rd_05_22255 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[][] graph;
    static int[][][] distance;
    static int[][][] dir = {
            {{1,0},{-1,0},{0,1},{0,-1}},
            {{1,0},{-1,0}},
            {{0,1},{0,-1}}
    };
    static Info start, end;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][M+1];
        distance = new int[N+1][M+1][3];

        start = new Info(sc.nextInt(), sc.nextInt(), 0,0);
        end = new Info(sc.nextInt(), sc.nextInt(), 0,0);


        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                graph[i][j] = sc.nextInt();
                for (int k = 0; k < 3; k++) {
                    distance[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }
    static void func(){
        dijkstra();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, distance[end.x][end.y][i]);
        }

        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }

        System.out.println(ans);
    }

    static void dijkstra(){
        Queue<Info> Q = new PriorityQueue<>();
        Q.add(start);
        distance[start.x][start.y][start.count] = 0;

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(distance[current.x][current.y][current.count] < current.value){
                continue;
            }

            int nextCount = (current.count + 1) % 3;

            for(int[] currentDir : dir[nextCount]){
                int nextX = current.x + currentDir[0];
                int nextY = current.y + currentDir[1];

                // 격자범위를 벗어나거나 벽이 존재하는 경우
                if(nextX > N || nextX <= 0 || nextY > M || nextY <= 0 || graph[nextX][nextY] == -1){
                    continue;
                }

                // 최소값 갱신이 안되는 경우
                if(distance[nextX][nextY][nextCount] <= current.value + graph[nextX][nextY]){
                    continue;
                }

                distance[nextX][nextY][nextCount] = current.value + graph[nextX][nextY];
                Q.add(new Info(nextX, nextY, distance[nextX][nextY][nextCount], nextCount));
            }

        }
    }


    public static void main(String[] args) {
        input();
        func();
    }
    static class Info implements Comparable<Info>{
        int x;
        int y;
        int value;
        int count;
        public Info(int x, int y, int value, int count){
            this.x = x;
            this.y = y;
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Info o){
            return this.value - o.value;
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
