package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1697
 */
public class Q06_1697 {
    static FastReader sc = new FastReader();
    static int N,K;
    static boolean[] visited;
    static int[] distance;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];
        distance = new int[100001];
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visited[N] = true;
        distance[N] = 0;

        while (!Q.isEmpty()){
            int current = Q.poll();
            int[] next = new int[3];

            next[0] = current -1;
            next[1] = current +1;
            next[2] = current * 2;

            for (int i = 0; i < 3; i++) {
                if(next[i] >= 0 && next[i] <= 100000 && !visited[next[i]]){
                    Q.add(next[i]);
                    visited[next[i]] = true;
                    distance[next[i]] = distance[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(distance[K]);
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
