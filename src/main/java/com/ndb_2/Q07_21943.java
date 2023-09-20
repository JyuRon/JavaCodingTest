package com.ndb_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/21943
 */
public class Q07_21943 {
    static FastReader sc = new FastReader();
    static int N, P, Q;
    static int[] nums;
    static Map<Integer, List<Integer>> tmp;
    static int answer = Integer.MIN_VALUE;

    static void input(){
        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        P = sc.nextInt();
        Q = sc.nextInt();

        tmp = new HashMap<>();
        for (int i = 0; i <= Q; i++) {
            tmp.put(i, new ArrayList<>());
        }
    }

    // Q+1의 개수만큼 그룹화 --> 그룹 내 합을 구함 --> 그룹 끼리의 곱을 구함
    static void func(int depth){
        if(depth == N){
            int result = 1;
            for (int i = 0; i <= Q; i++) {
                int sum = 0;
                List<Integer> currentGroup = tmp.get(i);

                for(int node : currentGroup){
                    sum += node;
                }

                result *= sum;
            }

            answer = Math.max(answer, result);
            return;
        }

        for (int i = 0; i <= Q; i++) {
            int current = nums[depth];
            tmp.get(i).add(current);
            func(depth + 1);
            tmp.get(i).remove(tmp.get(i).size() - 1);
        }
    }

    public static void main(String[] args) {
        input();
        func(0);
        System.out.println(answer);
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
