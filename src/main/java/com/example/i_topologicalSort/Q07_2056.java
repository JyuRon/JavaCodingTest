package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2056
 */
public class Q07_2056 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] inDegree, time, result;
    static ArrayList<Integer>[] graph;
    static void input(){
        N = sc.nextInt();
        time = new int[N+1];
        inDegree = new int[N+1];
        result = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N ; i++) {
            time[i] = sc.nextInt();
            int inDegreeCount = sc.nextInt();
            inDegree[i] = inDegreeCount;

            for (int j = 0; j < inDegreeCount; j++) {
                graph[sc.nextInt()].add(i);
            }
        }
    }

    static void func(){
        int ans = 0;

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                result[i] = time[i];
            }
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            ans = Math.max(result[current], ans);
            for(int next : graph[current]){
                inDegree[next]--;
                result[next] = Math.max(result[next], result[current] + time[next]);
                if(inDegree[next] == 0){
                    Q.add(next);
                }
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
