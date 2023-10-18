package com.boj_150.a_BruteForce.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q04_1436 {
    static FastReader sc = new FastReader();
    static int N;
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        N = sc.nextInt();

        int count = 0;
        int target = 666;

        while (count < 10000){

            int continuous = 0;
            int tmp = target;

            while (tmp != 0){
                if(tmp % 10 == 6){
                    continuous++;
                }else{
                    continuous = 0;
                }

                tmp /= 10;

                if(continuous == 3){
                    count++;
                    nums.add(target);
                    break;
                }
            }

            target++;
        }

        System.out.println(nums.get(N-1));

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
