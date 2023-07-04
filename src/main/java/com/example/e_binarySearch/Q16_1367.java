package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1637
 */
public class Q16_1367 {

    static FastReader sc = new FastReader();
    static int[][] nums;
    static int N;

    static void input(){
        N = sc.nextInt();
        nums = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
    }

    static void func(){
        long bottom = 1, top = Integer.MAX_VALUE, result = 0;
        int resultCount = 0;

        while (bottom <= top){
            long count = 0;
            long mid = (bottom + top) / 2;

            // 자연수 범위 중 mid 이하의 숫자가 짝수인지를 판단
            // 짝수인 경우 mid 이하는 모두 짝수 이기 때문에 상단을 탐색
            for (int i = 0; i < N; i++) {
                if(nums[i][0] > mid){
                    count += 0;
                }else if(nums[i][1] < mid ) {
                    count += (nums[i][1] - nums[i][0])/ nums[i][2] + 1;
                }else{
                    count += (mid- nums[i][0]) / nums[i][2] + 1;
                }
            }

            if(count % 2 == 0){
                bottom = mid + 1;
            }else{
                top = mid -1 ;
                result = mid;
            }
        }

        if(result == 0){
            System.out.println("NOTHING");
        }else{
            for (int i = 0; i < N; i++) {
                if(nums[i][0] <= result && result <= nums[i][1] && (result - nums[i][0]) % nums[i][2] == 0){
                    resultCount++;
                }
            }

            System.out.println(result + " " + resultCount);
        }
    }

    public static void main(String[] args){
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
