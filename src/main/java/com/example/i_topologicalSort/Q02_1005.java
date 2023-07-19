package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1005
 */
public class Q02_1005 {
    static FastReader sc = new FastReader();
    static int N,K,T,W;
    static int[] time, inDegree, result;
    static ArrayList<Integer>[] graph;

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();

        time = new int[N+1];
        graph = new ArrayList[N+1];
        inDegree = new int[N+1];
        result = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            time[i] = sc.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            inDegree[endNode]++;
        }

        W = sc.nextInt();


    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                result[i] = time[i];
            }
        }


        while (!Q.isEmpty()){
            int current = Q.poll();

            for(int next : graph[current]){
                inDegree[next]--;
                result[next] = Math.max(result[next], time[next] + result[current]);
                if(inDegree[next] == 0){
                    Q.add(next);
                }
            }
        }

        System.out.println(result[W]);
    }

    public static void main(String[] args) {
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
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
