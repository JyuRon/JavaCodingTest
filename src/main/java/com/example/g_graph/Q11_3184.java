package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3184
 */
public class Q11_3184 {

    static FastReader sc = new FastReader();
    static int N,M;
    static String[] graph;
    static boolean[][] visited;
    static int[] result;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new String[N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.next();
        }

        visited = new boolean[N][M];

        // 양과 늑대의 수를 기록할 배열 생성
        result = new int[2];
    }

    static void func(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && graph[i].charAt(j) != '#'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    static void bfs(int i, int j){
        Queue<Integer> Q = new LinkedList<>();
        visited[i][j] = true;
        Q.add(i);
        Q.add(j);

        int sheepCount = 0;
        int wolfCount = 0;

        if(graph[i].charAt(j) == 'o'){
            sheepCount++;
        }else if(graph[i].charAt(j) == 'v'){
            wolfCount++;
        }

        while (!Q.isEmpty()){
            int currentRow = Q.poll();
            int currentCol = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nextRow = currentRow + dir[k][0];
                int nextCol = currentCol + dir[k][1];

                // 지도 밖을 벗어나는 경우우
                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M){
                    continue;
                }

                // 이미 방문한 경우
                if(visited[nextRow][nextCol]){
                    continue;
                }

                // 이동하지 못하는 경우
                if(graph[nextRow].charAt(nextCol) == '#'){
                    continue;
                }

                visited[nextRow][nextCol] = true;
                Q.add(nextRow);
                Q.add(nextCol);

                // 양인지 늑대인지 판단
                if(graph[nextRow].charAt(nextCol) == 'o'){
                    sheepCount++;
                }else if(graph[nextRow].charAt(nextCol) == 'v'){
                    wolfCount++;
                }
            }
        }

        if(sheepCount > wolfCount){
            result[0] += sheepCount;
        }else{
            result[1] += wolfCount;
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
