package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9489
 */
public class Q10_9489 {
    static FastReader sc = new FastReader();
    static int N, K;
    static int[] graph;
    static int[] par;


    static void input(){
        graph = new int[N+1];
        par = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = sc.nextInt();
        }


    }

    static void func(){

        // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 주의하라.
        // 편의상 0번 정점의 부모를 -1 로 하자.
        par[0] = -1;
        par[1] = 0;

        // last := 이번에 자식 정점들을 찾을 노드의 인덱스
        int last = 1;
        for (int i = 2; i <= N; i++) {
            for (; i <= N; i++) {
                par[i] = last;
                if(i < N && graph[i] + 1 != graph[i+1]){
                    break;
                }
            }
            last++;
        }

        // 탐색하고자 하는 수의 인덱스
        int targetIndex = -1;
        for (int i = 1; i <= N; i++) {
            if(graph[i] == K){
                targetIndex = i;
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            // 부모의 부모 노드가 같으면서 부모노드는 다른 경우
            if(par[par[targetIndex]] == par[par[i]] && par[targetIndex] != par[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        while (true){
            N = sc.nextInt();
            K = sc.nextInt();

            if(N == 0 && K ==0){
                break;
            }

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
