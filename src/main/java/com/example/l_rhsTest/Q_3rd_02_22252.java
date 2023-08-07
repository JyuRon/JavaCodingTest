package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/22252
 * Map<String, Queue<Integer>> graph 로 구현했다가 시간초과
 */
public class Q_3rd_02_22252 {
    static FastReader sc = new FastReader();
    static int Q, current = 0;
    static Map<String, Integer> nameToNum;
    static Queue<Integer>[] value;
    static void input(){
        Q = sc.nextInt();
        nameToNum = new HashMap<>();
        value = new PriorityQueue[100001];
    }

    static void func(){
        long result = 0;
        for (int i = 0; i < Q; i++) {
            int command = sc.nextInt();
            String name = sc.next();
            int count = sc.nextInt();

            int num = getNum(name);

            if(command == 1){
                for (int j = 0; j < count; j++) {
                    value[num].add(sc.nextInt());
                }
            }else{
                while (count-- > 0){
                    if(!value[num].isEmpty()){
                        result += value[num].poll();
                    }
                }
            }
        }

        System.out.println(result);
    }


    static int getNum(String name){
        if(!nameToNum.containsKey(name)){
            nameToNum.put(name, current);
            value[current] = new PriorityQueue<>(Comparator.reverseOrder());
            current++;
        }

        return nameToNum.get(name);
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
