package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4803
 */
public class Q03_4803 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int vertex, edges;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] leaf;
    static List<Integer> currentVisited;

    static void input(){
        graph = new ArrayList[vertex+1];
        visited = new boolean[vertex+1];
        leaf = new int[vertex+1];

        for (int i = 1; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
    }

    static int func(){

        int count = 0;
        for (int i = 1; i <= vertex ; i++) {
            if(!visited[i]){
                currentVisited = new ArrayList<>();
                dfs(i);


                // 방문한 모든 정점의 차수 합을 구한다.
                int edgeCount = 0;
                for(int node : currentVisited){
                    edgeCount += graph[node].size();
                }

                // 모든 정점의 차수의 합은 간선 수의 2배이다.
                // 그래프가 트리인 경우 간선 수 - 1 = 정점 수 이다.
                if(edgeCount / 2 + 1 == currentVisited.size()){
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int value){
        visited[value] = true;
        currentVisited.add(value);

        for(int next : graph[value]){
            if(!visited[next]){
                dfs(next);
            }
        }

    }


    public static void main(String[] args) {

        int testCase = 0;
        while (true){
            testCase++;
            vertex = sc.nextInt();
            edges = sc.nextInt();

            if(vertex == 0 && edges == 0){
                break;
            }

            input();
            int result = func();
            sb.append("Case ").append(testCase).append(": ");

            if(result == 0){
                sb.append("No trees.").append("\n");
            }else if(result == 1){
                sb.append("There is one tree.").append("\n");
            }else{
                sb.append("A forest of ").append(result).append(" trees.").append("\n");
            }
        }

        System.out.println(sb.toString());

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
