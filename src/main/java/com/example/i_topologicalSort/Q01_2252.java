package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2252
 */
public class Q01_2252 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static int[] inDegree;
    static ArrayList<Integer>[] graph;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        inDegree = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            inDegree[endNode]++;
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();

        // 초기 진입 차수가 0인 정점들을 큐에 삽입
        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
            }
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            sb.append(current).append(" ");

            for(int next : graph[current]){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    Q.add(next);
                }
            }
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
