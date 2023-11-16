package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q02_10282 {
    static FastReader sc = new FastReader();
    static int t, n, d, c;
    static int[] distance;
    static List<Info>[] graph;
    static void input(){
        n = sc.nextInt();
        d = sc.nextInt();
        c = sc.nextInt();

        graph = new ArrayList[n+1];
        distance = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < d; i++) {
            int end = sc.nextInt();
            int start = sc.nextInt();
            int value = sc.nextInt();

            graph[start].add(new Info(end, value));
        }
    }

    static void func(){
        dijk();

        int count = 0;
        int time = 0;
        for (int i = 1; i <= n ; i++) {
            if(distance[i] != Integer.MAX_VALUE){
                count++;
                time = Math.max(time, distance[i]);
            }
        }

        System.out.println(count + " " + time);
    }

    static void dijk(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        Q.add(new Info(c, 0));
        distance[c] = 0;

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > distance[current.index]) continue;

            for(Info next : graph[current.index]){
                int dist = distance[current.index] + next.value;

                if(dist >= distance[next.index]) continue;

                distance[next.index] = dist;
                Q.add(new Info(next.index, dist));
            }

        }
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        while (t-- > 0){
            input();
            func();
        }

    }


    static class Info{
        int index;
        int value;
        public Info(int index, int value){
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
        }
}
