package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20364
 */
public class Q07_20364 {
    static FastReader sc = new FastReader();
    static boolean[] visited;
    static int N,Q;
    static void input(){
        N = sc.nextInt();
        Q = sc.nextInt();

        visited = new boolean[N+1];
    }

    static void func(){
        for (int i = 0; i < Q; i++) {
            int target = sc.nextInt();

            // 중복 체크를 위함
            int parent = target;
            int result = 0;

            // 해당 노드로 부터 최상단 노드까지 위로 올라갈때 막힘이 없어야 한다.
            while (parent >= 1){
                if(visited[parent]){
                    result = parent;
                }
                parent /= 2;
            }

            if(result == 0){
                visited[target] = true;
            }

            System.out.println(result);
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
