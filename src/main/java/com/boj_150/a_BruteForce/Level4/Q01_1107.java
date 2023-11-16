package com.boj_150.a_BruteForce.Level4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01_1107 {
    static FastReader sc = new FastReader();
    static int N, count, result = Integer.MAX_VALUE, length;
    static boolean[] nums;

    static void input(){
        N = sc.nextInt();
        count = sc.nextInt();

        nums = new boolean[10];

        for (int i = 0; i < count; i++) {
            nums[sc.nextInt()] = true;
        }
    }

    static boolean check(int num){
        int tmp = num;
        length = 0;

        if(num == 100){
            return true;
        }

        if(num == 0){
            if(nums[0]){
                return false;
            }
            length = 1;
        }

        while (tmp != 0){
            if(nums[tmp % 10]){
                return false;
            }
            tmp /= 10;
            length++;
        }

        return true;
    }
    public static void main(String[] args) {
        input();

        int i = 0;

        while(true){
            if(check(i)){
                result = Math.min(result, Math.abs(i - N) + length);
            }
            i++;

            if(i > 100 && (Math.abs(i - N) > 499900))
                break;
        }


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
