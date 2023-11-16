package com.boj_150.c_BinarySearch.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_2805 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }
    static void func(){
        int bottom = 0;
        int top = 1000000000;
        int result = 0;

        while (bottom <= top){
            int mid = (bottom + top) / 2;
            long tmp = 0;
            for (int i = 0; i < N; i++) {
                if(nums[i] - mid > 0){
                    tmp += nums[i] - mid;
                }
            }

            if(tmp >= M){
                bottom = mid + 1;
                result = mid;
            }else{
                top = mid - 1;
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
