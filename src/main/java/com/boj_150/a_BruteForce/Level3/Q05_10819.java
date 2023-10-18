package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Q05_10819 {
    static FastReader sc = new FastReader();
    static int N, result;
    static int[] nums;
    static boolean[] used;
    static void input(){
        N = sc.nextInt();
        nums = new int[N];
        used = new boolean[N];
        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void dfs(int depth, List<Integer> value){
        if(depth == N){
            int tmp = 0;
            for (int i = 0; i < N - 1; i++) {
                int left = value.get(i);
                int right = value.get(i+1);

                tmp += Math.abs(left - right);
            }

            result = Math.max(result, tmp);
        }

        for (int i = 0; i < N; i++) {
            if(used[i]){
                continue;
            }

            used[i] = true;
            value.add(nums[i]);
            dfs(depth + 1, value);
            used[i] = false;
            value.remove(value.size() - 1);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(0, new ArrayList<>());
        System.out.println(result);
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
