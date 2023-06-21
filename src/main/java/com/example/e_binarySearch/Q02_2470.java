package com.example.e_binarySearch;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2470
 */
public class Q02_2470 {

    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static List<Integer> nums;
    static int N;


    static void input() {
        N = sc.nextInt();
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }

    }

    static void func() {
        Collections.sort(nums);

        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;

        for (int i = 0; i < N-1; i++) {
            int tmpIndex = search(i+1, N-1, nums.get(i));

            int plusNum = nums.get(i) + nums.get(tmpIndex);
            if(result > Math.abs(plusNum)){
                result = Math.abs(plusNum);
                left = nums.get(i);
                right = nums.get(tmpIndex);
            }


            // index 가 0일때 비교하는 것으로 가정, 정답 4
            // 1 2 3 4 5 6  mid = 3, res = 6
            // 4 5 6        mid = 5, res = 5
            // 5            mid = 5, res = 5
            tmpIndex--;
            if(tmpIndex > i){
                plusNum = nums.get(i) + nums.get(tmpIndex);
                if(result > Math.abs(plusNum)){
                    result = Math.abs(plusNum);
                    left = nums.get(i);
                    right = nums.get(tmpIndex);
                }
            }
        }

        sb.append(left).append(" ").append(right);
        System.out.println(sb.toString());
    }

    // 합이 음수면 오른쪽으로 가야 하고
    // 합이 양수면 왼쪽으로 가야함
    static int search(int bottom, int top, int num) {
        int res = top;

        while(bottom <= top){
             int midIndex = (bottom + top) / 2;
             if(num + nums.get(midIndex) < 0){
                bottom = midIndex + 1;
             }else{
                 // 양수이거나 0 일때
                 res = midIndex;
                 top = midIndex - 1;
             }
        }
        // 0 1 2 3 4
        //
        return res;
    }


    public static void main(String[] args) {
        input();
        func();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
