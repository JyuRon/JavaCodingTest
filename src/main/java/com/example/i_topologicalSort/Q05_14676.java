package com.example.i_topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14676
 */
public class Q05_14676 {
    static FastReader sc = new FastReader();
    static int N,M,K;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;
    static int[] count;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        graph  = new ArrayList[N+1];
        inDegree = new int[N+1];
        count = new int[N+1];


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

        for (int i = 0; i < K; i++) {
            int state = sc.nextInt();
            int value = sc.nextInt();

            // 건설인 경우
            if(state == 1){
                // 건물을 지을 수 있는 상황인지 판단
                if(inDegree[value] == 0){
                    create(value);
                }else{
                    System.out.println("Lier!");
                    return;
                }
            }else{
                // 정상적인 방법으로 건물이 지어진 경우가 아님
                if(count[value] == 0){
                    System.out.println("Lier!");
                    return;
                }
                destroy(value);
            }
        }

        System.out.println("King-God-Emperor");
    }

    static void create(int value){
        count[value]++;

        // 해당 건물이 최초로 지어니는 경우
        if(count[value] == 1){
            for(int next : graph[value]){
                inDegree[next]--;
            }
        }

    }

    static void destroy(int value){
        count[value]--;

        // 해당 건물이 마지막 남은 건물인 경우
        if(count[value] == 0){
            for(int next : graph[value]){
                inDegree[next]++;
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
