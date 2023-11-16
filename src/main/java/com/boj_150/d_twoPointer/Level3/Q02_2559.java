package com.boj_150.d_twoPointer.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q02_2559 {
    static FastReader sc = new FastReader();
    static int N, K;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        nums = new int[N+1];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void func(){
        int left = 0;
        int right = K - 1;
        int tmp = 0, result = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            tmp += nums[i];
        }

        while (right < N){
            result = Math.max(result, tmp);
            tmp -= nums[left++];
            tmp += nums[++right];
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
