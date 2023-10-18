package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q03_1182 {
    static FastReader sc = new FastReader();
    static int N, S, result;
    static int[] nums;

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void dfs(int depth, int value){
        if(depth == N){
            if(value == S){
                result++;
            }
            return;
        }

        dfs(depth + 1, value + nums[depth]);
        dfs(depth + 1, value);
    }

    public static void main(String[] args) {
        input();
        dfs(0, 0);

        // S가 0인 경우 모두 선택되지 않은 케이스를 제거해야 한다.
        if(S == 0){
            result--;
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
