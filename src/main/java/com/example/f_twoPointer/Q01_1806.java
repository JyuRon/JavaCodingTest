package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1806
 */
public class Q01_1806 {

    static FastReader sc = new FastReader();
    static int N, S;
    static int[] nums;

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void func(){
        int left = 0, right = 0;
        int sum = nums[left];
        int result = Integer.MAX_VALUE;
        while (left < N){

            // 합이 기준보다 큰 경우 왼쪽 포인터를 한칸 이동 시킨다.
            if(sum >= S){
                result = Math.min(result, right - left + 1);

                sum -= nums[left];
                left++;

                // left 와 right 가 같은 상황이면 숫자 1개만 보고 있는 상황
                // 이때 left++ 를 시도하면 left > right 상황 발생
                if(left > right && left < N){
                    right = left;
                    sum = nums[left];
                }
            }else if(right < N-1){
                // 합이 미달인 경우 오른쪽 포인터를 이동 시켜야 한다.
                right++;
                sum += nums[right];
            }else{
                // right 가 배열 끝까지 이동한 상황이며 합 또한 기준 미달인 상황
                break;
            }

        }

        if(result == Integer.MAX_VALUE) {
            System.out.println("0");
        }else{
            System.out.println(result);
        }

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
