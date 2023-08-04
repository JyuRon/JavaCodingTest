package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21278
 */
public class Q_2nd_04_21278 {
    static FastReader sc = new FastReader();
    static int N, M;
    static List<Integer>[] graph;
    static int[] distance;
    static int result = Integer.MAX_VALUE, resultL, resultR;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
    }
    static void func(){
        for (int i = 1; i < N; i++) {
            if(graph[i].isEmpty()){
                continue;
            }
            for (int j = i+1; j <= N ; j++) {
                if(graph[j].isEmpty()){
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(resultL + " " + resultR + " " + result);
    }
    static void bfs(int left, int right){
        distance = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            distance[i] = -1;
        }
        distance[left] = 0;
        distance[right] = 0;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(left);
        Q.add(right);

        while (!Q.isEmpty()){
            int current = Q.poll();
            for(int next : graph[current]){
                if(distance[next] == -1){
                    distance[next] = distance[current] + 1;
                    Q.add(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N ; i++) {
            sum += distance[i];
        }

        sum *= 2;

        if(result > sum){
            result = sum;
            resultL = left;
            resultR = right;
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
