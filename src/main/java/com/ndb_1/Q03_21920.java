package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21920
 * 서로소, 약수 구하기
 */
public class Q03_21920 {
    static FastReader sc = new FastReader();
    static boolean[] visited;
    static int[] A;
    static int N,X;

    static void input(){
        visited = new boolean[1000001];
        Arrays.fill(visited, true);

        N = sc.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        X = sc.nextInt();
    }

    static void func(){
        checkPrime();
        long sum = 0;
        int count = 0;
        for(int num : A){
            if(visited[num]){
                sum += num;
                count++;
            }
        }

        System.out.printf("%.6f", (double)sum / count);
    }

    static void checkPrime(){
        visited[0] = false;
        visited[1] = false;

        List<Integer> Q = new ArrayList<>();

        for (int i = 1; i * i <= X ; i++) {
            if(X % i == 0){
                Q.add(i);
            }
        }

        int size = Q.size();

        for (int i = 0; i < size; i++) {
            Q.add(X / Q.get(i));
        }

        Collections.sort(Q);

        for(int num : Q){
            if(visited[num]){
                for (int j = num; j <= 1000000 ; j += num) {
                    visited[j] = false;
                }
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
