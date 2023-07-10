package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2667
 */
public class Q02_2667 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N;
    static String[] graph;
    static boolean[][] visited;
    static int count = 0;
    // 상, 하, 좌, 우
    static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    static List<Integer> result = new ArrayList<>();
    static void input(){
        N = sc.nextInt();
        graph = new String[N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = sc.next();
        }

    }

    static void dfs(int i, int j){
        visited[i][j] = true;
        count++;

        for (int k = 0; k < 4; k++) {

            int x = i + dir[k][0];
            int y = j + dir[k][1];

            // 행 범위를 벗어나는 경우
            if(x >= N || x < 0){
                continue;
            }

            // 열 범위를 벗어나는 경우
            if(y >= N || y < 0){
                continue;
            }

            // 이미 방문한 이력이 있는 경우
            if(visited[x][y]){
                continue;
            }

            // 숫자가 0인 경우
            if(graph[x].charAt(y) == '0'){
                continue;
            }

            dfs(x, y);
        }
    }
    static void func(){

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 탐색할 필요가 없거나 이미 방문한 기록이 있는 경우
                if(graph[i].charAt(j) == '0' || visited[i][j]){
                    continue;
                }

                count = 0;
                dfs(i,j);
                result.add(count);
            }
        }

        Collections.sort(result);
        for(int i : result){
            sb.append(i).append("\n");
        }
        System.out.println(result.size());
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
