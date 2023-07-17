package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5639
 */
public class Q05_5639 {
    static StringBuffer sb = new StringBuffer();
    static List<Integer> graph = new ArrayList<>();
    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        try{
            // !(input = br.readLine()).equals("")
            while ((input = br.readLine()) != null){
                graph.add(Integer.parseInt(input));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void func(){
        dfs(0, graph.size() - 1);
    }

    static void dfs(int start, int end){
        if(start > end){
            return;
        }

        int rootNode = graph.get(start);
        int mid = end;
        for (int i = start + 1; i <= end; i++) {
            if(graph.get(i) < rootNode){
                mid = i;
            }else{
                break;
            }
        }

        dfs(start + 1, mid);
        dfs(mid+1, end);
        sb.append(rootNode).append("\n");
    }

    public static void main(String[] args) {
        input();
        func();
        System.out.println(sb.toString());
    }

}
