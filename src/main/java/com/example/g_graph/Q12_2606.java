package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2606
 */
public class Q12_2606 {

    static FastReader sc = new FastReader();
    static int vertex, edges;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph;

    static void input(){
        vertex = sc.nextInt();
        edges = sc.nextInt();

        visited = new boolean[vertex+1];
        graph = new HashMap<>();

        for (int i = 1; i <= vertex ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }
    }

    static void func(){
       Queue<Integer> Q = new LinkedList<>();
       Q.add(1);
       visited[1] = true;
       int result = 0;

       while (!Q.isEmpty()){
           int currentNode = Q.poll();
           for (int i = 0; i < graph.get(currentNode).size(); i++) {
               if(!visited[graph.get(currentNode).get(i)]){
                   Q.add(graph.get(currentNode).get(i));
                   visited[graph.get(currentNode).get(i)] = true;
                   result++;
               }
           }
       }

        System.out.println(result);
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
