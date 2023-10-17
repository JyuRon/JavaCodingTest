package com.boj_150.a_BruteForce.Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2309
 */
public class Q02_2309 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int[] nums = new int[9];
    static int total;

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }


        int target1 = -1, target2 = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(total - nums[i] - nums[j] == 100){
                    target1 = i;
                    target2 = j;
                    break;
                }
            }

            if(target1 != -1){
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if(i == target1 || i == target2){
                continue;
            }
            result.add(nums[i]);
        }

        Collections.sort(result);

        for (int i = 0; i < 7; i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb.toString());
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
