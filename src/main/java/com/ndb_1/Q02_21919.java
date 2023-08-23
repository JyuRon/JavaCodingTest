package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21919
 * 소수 구하기
 */
public class Q02_21919 {
    static FastReader sc = new FastReader();
    static int N;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static void input(){
        visited = new boolean[1000001];
        Arrays.fill(visited, true);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
    }
    static void select(){
        visited[0] = false; visited[1] = false;

        for (int i = 2; i <= 1000 ; i++) {
            if(visited[i]){
                for (int j = i * i; j <= 1000000 ; j+=i) {
                    visited[j] = false;
                }
            }
        }
    }

    static long gcd(long a, long b){

        if(b == 0){
            return a;
        }

        return gcd(b,a % b);
    }

    static void func(){
        select();

        Queue<Integer> Q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : list){
            if(visited[i])
                Q.add(i);
        }

        if(Q.isEmpty()){
            System.out.println(-1);
        }else{
            long first = Q.poll();

            while(!Q.isEmpty()){
                int next = Q.poll();
                first = (first * next) / gcd(first, next);
            }

            System.out.println(first);
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
