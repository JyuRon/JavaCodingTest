package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q04_4485 {
    static FastReader sc = new FastReader();
    static int n, count = 1;
    static int[][] graph, distance, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static void input(){
        graph = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void func(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        Q.add(new Info(0,0,graph[0][0]));
        distance[0][0] = graph[0][0];

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > distance[current.x][current.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dir[i][0];
                int nextY = current.y + dir[i][1];

                // 범위를 벗어난 경우
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                // 판단 시도가치가 없는 경우
                int t = current.value + graph[nextX][nextY];

                if(t >= distance[nextX][nextY]) continue;

                distance[nextX][nextY] = t;
                Q.add(new Info(nextX, nextY, t));
            }
        }

        System.out.println("Problem " + count++ + ": " + distance[n-1][n-1]);
    }


    static class Info{
        int x;
        int y;
        int value;
        public Info(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        while (true){
            n = sc.nextInt();
            if(n == 0) return;
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
