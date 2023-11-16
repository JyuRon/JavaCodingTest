package com.boj_150.f_Tree.Level2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Q03_9934 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static List<Integer> index = new ArrayList<>();
    static int total;
    static int[] nums, input;
    public static void main(String[] args) {
        int K = sc.nextInt();


        // 완전 트리의 노드 개수 파악
        int tmp = 1;
        while (K-- > 0){
            total += tmp;
            tmp *= 2;
        }

        // 결과값 입력
        input = new int[total + 1];
        for (int i = 1; i <= total; i++) {
            input[i] = sc.nextInt();
        }

        // 조건에 맞게 순회한 경우 순서 조회
       dfs(1);


        // 순서에 맞게 재배치
        nums = new int[total + 1];
        for (int i = 1; i <= total; i++) {
            nums[index.get(i-1)] = input[i];
        }

        int start = 1;
        int end = 1;
        int plus = 2;

        while (end <= total){

            for (int i = start; i <= end ; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            start = end + 1;
            end += plus;
            plus *= 2;
        }

        System.out.println(sb.toString());

    }

    static void dfs(int value){

        if(value * 2 <= total)
            dfs(value * 2);

        index.add(value);

        if(value * 2 <= total)
            dfs(value * 2 + 1);
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
