package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/20183
 */
public class Q_1st_08_20183 {
    static FastReader sc = new FastReader();
    static int N, M, A, B;
    static long C;
    static ArrayList<Info>[] graph;
    static long[] distance;


    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextLong();

        distance = new long[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();;
            int endNode = sc.nextInt();
            int value = sc.nextInt();

            graph[startNode].add(new Info(endNode, value));
            graph[endNode].add(new Info(startNode, value));
        }
    }

    static void func(){
        long bottom = 1;
        long top = 1000000001;
        long ans = top;

        while (bottom <= top){
            long mid = (bottom + top) / 2;
            if(dijkstra(mid)){
                ans = mid;
                top = mid - 1;
            }else{
                bottom = mid + 1;
            }
        }

        if(ans == 1000000001){
            ans = -1;
        }

        System.out.println(ans);

    }

    static boolean dijkstra(long value){

        for (int i = 1; i <= N ; i++) {
            distance[i] = Long.MAX_VALUE;
        }

        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingLong(o -> o.value));
        Q.add(new Info(A,0));
        distance[A] = 0;

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > distance[current.index]){
                continue;
            }



            for(Info next : graph[current.index]){
                if(next.value > value){
                    continue;
                }

                if(distance[current.index] + next.value < distance[next.index]){
                    distance[next.index] = distance[current.index] + next.value;
                    Q.add(new Info(next.index, distance[next.index]));
                }
            }
        }

        return distance[B] <= C;
    }


    public static void main(String[] args) {
        input();
        func();
    }

    static class Info{
        int index;
        long value;
        public Info(int index , long value){
            this.index = index;
            this.value = value;
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
        public long nextLong(){
            return Long.parseLong(next());
        }
    }
}
