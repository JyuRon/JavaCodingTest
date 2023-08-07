package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22253
 */
public class Q_3rd_03_22253 {
    static FastReader sc = new FastReader();
    static int N, mod = 1000000007;
    static int[][] Dy;
    static List<Integer>[] graph;
    static int[] value;

    static void input(){
        N = sc.nextInt();
        Dy = new int[N+1][10];
        graph = new ArrayList[N+1];

        value = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            value[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

    }

    static void func(){
        dfs(1, -1);

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += Dy[1][i];
            ans %= mod;
        }
        System.out.println(ans);
    }

    static void dfs(int current, int parent){

        Dy[current][value[current]] = 1;


        for(int next : graph[current]){
            if(next == parent) continue;
            dfs(next, current);


            // 전구를 키지 않았을 때의 경우의 수
            for (int i = 0; i < 10; i++) {
                Dy[current][i] += Dy[next][i];
                Dy[current][i] %= mod;

            }

            // 전구를 켰을때의 경우의 수
            for (int i = value[current]; i < 10 ; i++) {
                Dy[current][value[current]] += Dy[next][i];
                Dy[current][value[current]] %= mod;
            }
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
