package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21276
 */
public class Q_2nd_02_21276 {
    static FastReader sc = new FastReader();
    static StringBuffer sb= new StringBuffer();
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, List<String>> childList = new HashMap<>();
    static Map<String, Integer> inDegree = new HashMap<>();
    static int N, M;
    static void input(){
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            graph.put(name, new ArrayList<>());
            childList.put(name, new ArrayList<>());
            inDegree.put(name, 0);
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String startNode = sc.next();
            String endNode = sc.next();

            graph.get(endNode).add(startNode);
            inDegree.put(startNode, inDegree.get(startNode) + 1);
        }
    }

    static void func(){
        List<String> sortedName = new ArrayList<>(graph.keySet());
        Collections.sort(sortedName);

        Queue<String> Q = new LinkedList<>();
        List<String> rootList = new ArrayList<>();
        for(String name : sortedName){
            if(inDegree.get(name) == 0){
                rootList.add(name);
                Q.add(name);
            }
        }

        // 가문의 개수와 가문장의 이름을 출력
        System.out.println(rootList.size());
        for(String root : rootList){
            sb.append(root).append(" ");
        }
        sb.append("\n");

        while (!Q.isEmpty()){
            String current = Q.poll();
            for(String next : graph.get(current)){
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0){
                    Q.add(next);
                    childList.get(current).add(next);
                }
            }
        }

        for(String name : sortedName){
            List<String> list = childList.get(name);
            Collections.sort(list);
            sb.append(name).append(" ").append(list.size()).append(" ");

            for(String child : list){
                sb.append(child).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
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
