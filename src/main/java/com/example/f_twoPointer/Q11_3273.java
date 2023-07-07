package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11_3273 {
    static FastReader sc = new FastReader();
    static int N,X;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        X = sc.nextInt();
        Arrays.sort(nums);
    }

    static void func(){
        int left = 0;
        int right = N-1;
        int count = 0;

        while (left < right){
            if(nums[left] + nums[right] > X){
                right--;
            }else{
                if(nums[left] + nums[right] == X){
                    count++;
                }
                left++;
            }
        }


        System.out.println(count);
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
                while(st == null || !st.hasMoreElements()){
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
