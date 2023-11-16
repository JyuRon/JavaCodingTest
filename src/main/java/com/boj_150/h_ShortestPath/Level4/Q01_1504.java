package com.boj_150.h_ShortestPath.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q01_1504 {
    static FastReader sc = new FastReader();
    static int N, E, V1, V2;
    static int[] v1Distance, v2Distance;
    static List<Info>[] graph;

    public static void main(String[] args) {
        N = sc.nextInt();
        E = sc.nextInt();
        v1Distance = new int[N+1];
        v2Distance = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            graph[start].add(new Info(end, value));
            graph[end].add(new Info(start, value));
        }

        V1 = sc.nextInt();
        V2 = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            v1Distance[i] = Integer.MAX_VALUE;
            v2Distance[i] = Integer.MAX_VALUE;
        }

        v1();
        v2();

        int result = 0;

        // v1 -> start + v1 -> v2 + v2 -> end
        int tmp1;
        if(v1Distance[1] == Integer.MAX_VALUE || v1Distance[V2] == Integer.MAX_VALUE || v2Distance[N] == Integer.MAX_VALUE){
            tmp1 = -1;
        }else{
            tmp1 = v1Distance[1] + v1Distance[V2] + v2Distance[N];
        }



        // v2 -> start + v2 -> v1 + v1 -> end
        int tmp2;
        if(v2Distance[1] == Integer.MAX_VALUE ||  v2Distance[V1] == Integer.MAX_VALUE ||  v1Distance[N] == Integer.MAX_VALUE){
            if(tmp1 == -1) result = -1;
        }else{
            tmp2 = v2Distance[1] + v2Distance[V1] + v1Distance[N];

            if(tmp1 == -1){
                result = tmp2;
            }else{
                result = Math.min(tmp1, tmp2);
            }
        }


        System.out.println(result);
    }

    static void v1(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        v1Distance[V1] = 0;
        Q.add(new Info(V1, 0));

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > v1Distance[current.node]){
                continue;
            }

            for(Info next : graph[current.node]){
                int distance = v1Distance[current.node] + next.value;

                if(distance < v1Distance[next.node]){
                    v1Distance[next.node] = distance;
                    Q.add(new Info(next.node, distance));
                }
            }
        }

    }

    static void v2(){
        Queue<Info> Q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        v2Distance[V2] = 0;
        Q.add(new Info(V2, 0));

        while (!Q.isEmpty()){
            Info current = Q.poll();

            if(current.value > v2Distance[current.node]) continue;

            for(Info next : graph[current.node]){
                int distance = v2Distance[current.node] + next.value;
                if(distance < v2Distance[next.node]){
                    v2Distance[next.node] = distance;
                    Q.add(new Info(next.node, distance));
                }
            }
        }
    }

    static class Info{
        int node;
        int value;
        public Info(int node, int value){
            this.node = node;
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
