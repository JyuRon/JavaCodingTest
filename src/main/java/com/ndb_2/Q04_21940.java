package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * * https://www.acmicpc.net/problem/21940
        */
public class Q04_21940 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M,K;
    static int[][] distance;
    static int[] friend;
    static int INF = Integer.MAX_VALUE / 2;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        distance = new int[N+1][N+1];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            distance[start][end] = value;
        }

        K = sc.nextInt();
        friend = new int[K];
        for (int i = 0; i < K; i++) {
            friend[i] = sc.nextInt();
        }
    }

    static void func(){
        List<Integer> result = new ArrayList<>();

        // 플로이드 워셜 ( i 번째를 경유할때 최소값을 판별하는 알고리즘)
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                for (int k = 1; k <= N ; k++) {
                    if(distance[j][k] > distance[j][i] + distance[i][k])
                        distance[j][k] = distance[j][i] + distance[i][k];
                }
            }
        }

        // 각 목적지마다 최장 왕복거리를 구한다.
        int maxValue = INF;
        for (int i = 1; i <= N; i++) {
            int current = 0;
            for(int start : friend){
                current = Math.max(current, distance[start][i] + distance[i][start]);
            }

            if(current >= INF){
                current = INF;
            }

            if(maxValue > current){
                result.clear();
                result.add(i);
                maxValue = current;
            }else if(maxValue == current){
                result.add(i);
            }
        }

        for(int x : result){
            sb.append(x).append(" ");
        }

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
