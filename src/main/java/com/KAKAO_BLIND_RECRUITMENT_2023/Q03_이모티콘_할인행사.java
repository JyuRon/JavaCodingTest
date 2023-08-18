package com.KAKAO_BLIND_RECRUITMENT_2023;
import java.util.*;

/**
 * BruteForce
 */
public class Q03_이모티콘_할인행사 {
    static int n,m, ansService, ansMoney;
    static int[] rate = {10,20,30,40};

    static int[] solution(int[][] users, int[] emoticons) {

        n = users.length;
        m = emoticons.length;

        dfs(new ArrayList<Integer>(),users,emoticons );

        int[] answer = {ansService, ansMoney};
        return answer;
    }

    static void dfs(List<Integer> list, int[][] users, int[] emoticons){

        // 각 이모티콘에 대한 할인율이 정해진 경우
        if(list.size() == m){

            // 현재 경우의 수에 대한 결과값 저장
            int service = 0;
            int money = 0;


            for(int i = 0; i < n; i++ ){
                int count = 0;

                // 사용자의 할인율 이상인 이모티콘에 대해 합 계산
                for(int j=0; j < m; j++){
                    if(users[i][0] <=list.get(j)){
                        count += ((100 - list.get(j)) * emoticons[j] )  / 100;
                    }
                }

                // 총 구매액이 사용자 설정보다 높다면 서비스 가입
                if(count >= users[i][1]){
                    service++;
                }else{
                    money += count;
                }
            }


            // 최종 결과 답 계산
            if(service > ansService ){
                ansService = service;
                ansMoney = money;
            }

            if(service == ansService){
                ansMoney = Math.max(ansMoney, money);
            }

            return;
        }

        // 모든 할인율에 대한 경우의 수 생성
        for(int i=0; i < 4 ;i++){
            list.add(rate[i]);
            dfs(list, users, emoticons);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        solution(users, emoticons);
    }
}
