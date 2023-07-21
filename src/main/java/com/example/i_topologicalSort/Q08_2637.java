package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2637
 */
public class Q08_2637 {
    static FastReader sc = new FastReader();
    static ArrayList<int[]>[] graph;
    static int[] result, inDegree;
    static int N,M;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N+1];
        result = new int[N+1];
        inDegree = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int needCount = sc.nextInt();

            graph[startNode].add(new int[]{endNode, needCount});
            inDegree[endNode]++;
        }
    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                result[i] = 1;
            }
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            for(int[] next : graph[current]){
                inDegree[next[0]]--;
                result[next[0]] += result[current] * next[1];
                if(inDegree[next[0]] == 0){
                    Q.add(next[0]);
                }
            }

            if(!graph[current].isEmpty()){
                result[current] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(result[i] != 0)
                System.out.println(i + " " + result[i]);
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
