package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20166
 */
public class Q_1st_03_20166 {
    static FastReader sc = new FastReader();
    static int N, M, K;
    static String[] graph;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static Map<String, Integer> Dy = new HashMap<>();
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        graph = new String[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = " ".concat(sc.next());
        }
    }
    static void func(){
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                dfs(i,j, "", 1);
            }
        }

    }

    static void dfs(int row, int col, String content, int depth){
        if(depth > 5){
            return;
        }

        String tmp = content.concat(String.valueOf(graph[row].charAt(col)));

        if(Dy.containsKey(tmp)){
            Dy.put(tmp, Dy.get(tmp) + 1);
        }else{
            Dy.put(tmp, 1);
        }

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];

            if(nextRow > N){
                nextRow = 1;
            }

            if(nextRow < 1){
                nextRow = N;
            }

            if(nextCol > M){
                nextCol = 1;
            }

            if(nextCol < 1){
                nextCol = M;
            }

            dfs(nextRow, nextCol, tmp, depth + 1);
        }
    }

    public static void main(String[] args) {
        input();
        func();

        for (int i = 0; i < K; i++) {
            Integer result = Dy.get(sc.next());
            if(result == null){
                result = 0;
            }
            System.out.println(result);
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
