package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21937
 */
public class Q01_21937 {
    static FastReader sc = new FastReader();
    static int[] distance;
    static List<Integer>[] graph;
    static int N,M,X;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N+1];
        distance = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M ; i++) {
            int end = sc.nextInt();
            int start = sc.nextInt();

            graph[start].add(end);
        }

        X = sc.nextInt();
    }

    static void func(){
        int ans = 0;
        Queue<Integer> Q = new LinkedList<>();

        Q.add(X);

        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                if(distance[next] == 0){
                    distance[next] = 1;
                    Q.add(next);
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            if(distance[i] != 0){
                ans++;
            }
        }

        System.out.println(ans);
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
