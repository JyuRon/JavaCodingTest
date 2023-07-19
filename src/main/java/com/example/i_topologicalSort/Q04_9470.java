package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9470
 */
public class Q04_9470 {
    static FastReader sc = new FastReader();
    static int testCase, K,M,P;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;
    static int[][] result;

    static void input(){
        K = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();

        inDegree = new int[M+1];
        graph = new ArrayList[M+1];
        result = new int[M+1][2];

        for (int i = 1; i <=M ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            inDegree[endNode]++;
        }

    }

    static void func(){
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= M ; i++) {
            if(inDegree[i] == 0){
                Q.add(i);
                result[i][0] = 1;
                result[i][1] = 1;
            }
        }

        while (!Q.isEmpty()){
            int current = Q.poll();
            for(int next : graph[current]){
                inDegree[next]--;

                if(result[next][0] < result[current][0]){
                    result[next][0] = result[current][0];
                    result[next][1] = 1;
                }else if(result[next][0] == result[current][0]){
                    result[next][1]++;
                }

                if(inDegree[next] == 0){
                    Q.add(next);
                    if(result[next][1] >= 2){
                        result[next][0]++;
                        result[next][1] = 1;
                    }
                }
            }
        }

        System.out.println(K + " " + result[M][0]);


    }

    public static void main(String[] args) {
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
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
