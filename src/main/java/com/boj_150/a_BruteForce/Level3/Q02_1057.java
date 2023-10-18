package com.boj_150.a_BruteForce.Level3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Q02_1057 {
    static FastReader sc = new FastReader();
    static int N, A, B;
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();
    static boolean flag = false;
    static void input(){
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            nums.add(i);
        }
    }

    static void func(){
        int count = 0;
        while (!flag && nums.size() != 1){
            count++;
            verse();
        }

        if(!flag){
            System.out.println(-1);
            return;
        }

        System.out.println(count);
    }

    static void verse(){
        int size = nums.size();

        if(nums.size() % 2 == 1){
            size = size - 1;
        }

        for (int i = 0; i < size; i+=2) {
            int left = i;
            int right = i+1;

            // A와 B가 만난 경우
            if(nums.get(left) == A && nums.get(right) == B){
                flag = true;
                break;
            }

            if(nums.get(left) == B && nums.get(right) == A){
                flag = true;
                break;
            }

            // A인 경우 승리
            if(nums.get(left) == A || nums.get(right) == A){
                tmp.add(A);
                continue;
            }

            // B인 경우 승리
            if(nums.get(left) == B || nums.get(right) == B){
                tmp.add(B);
                continue;
            }

            // 아무나 승리시키기
            tmp.add(nums.get(left));
        }

        if(nums.size() % 2 != 0){
            tmp.add(nums.get(nums.size() - 1));
        }

        nums.clear();
        for (int i = 0; i < tmp.size(); i++) {
            nums.add(tmp.get(i));
        }
        tmp.clear();
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
