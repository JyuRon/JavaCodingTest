package com.boj_150.a_BruteForce.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q02_1065 {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();


        int count = 0;
        int i = 1;

        while (i <= N){

            int num = i;

            int target = i % 10;
            int diff = 10;
            boolean flag = true;

            num /= 10;

            while (num != 0){

                // 첫 비교 대상인 경우
                if(diff == 10){
                    diff = num % 10 - target;
                }else{
                    if(num % 10 - target != diff){
                        flag = false;
                        break;
                    }
                }
                target = num % 10;
                num /= 10;
            }

            if(flag){
                count++;
            }

            i++;
        }
        System.out.println(count);
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
