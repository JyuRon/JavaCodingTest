package com.boj_150.e_Graph.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q01_7576 {
    static FastReader sc = new FastReader();
    static int N, M, result;
    static int[][] graph, dir = {{-1,0},{1,0},{0,-1},{0,1}}, distance;
    static Queue<Integer> Q = new LinkedList<>();
    static void input(){
        M = sc.nextInt();
        N = sc.nextInt();

        graph = new int[N][M];
        distance = new int[N][M];


        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
            for (int j = 0; j < M; j++) {
                int target = sc.nextInt();
                graph[i][j] = target;

                if(target == 1){
                    Q.add(i); Q.add(j);
                    distance[i][j] = 0;
                }
            }
        }
    }

    static void func(){

        while (!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                // 범위를 벗어나는 경우
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }

                // 갈 수 없는 경우
                if(graph[nextX][nextY] == -1){
                    continue;
                }

                // 이미 방문한 경우
                if(distance[nextX][nextY] != -1){
                    continue;
                }

                distance[nextX][nextY] = distance[x][y] + 1;
                result = Math.max(result, distance[nextX][nextY]);
                Q.add(nextX); Q.add(nextY);

            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0 && distance[i][j] == -1){
                    result = -1;
                    break;
                }
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
