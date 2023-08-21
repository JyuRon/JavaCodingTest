package com.KAKAO_BLIND_RECRUITMENT_2023;

/**
 * 최초 전략 : 4^2500 의 시행 횟수를 시도하여 순수하게 dfs 방식은 불가하다 생각하여 dp 로 접근
 *          dp 접근 또한 각 행렬 k번째 에 무작위 dir 로 도착했을 때 를 생각했지만 이 또한 경우의 수가 많음
 *
 * 1. dfs + 사고력
 * 2. 사전 순 정렬이며 최초 발견시 return
 */
public class Q06_미로_탈출_명령어 {
    static int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    static String[] addChar = {"d","l","r","u"};
    static String tmp;

    static String solution(int n, int m, int x, int y, int r, int c, int k) {
        tmp = "";
        String answer = "";

        dfs(n,m,x,y,r,c,k,"");

        if(tmp.equals("")){
            answer = "impossible";
        }else{
            answer = tmp;
        }
        return answer;
    }

    static boolean dfs(int n, int m, int x, int y, int r, int c, int k, String word){
        if(k == 0){
            if(x == r && y == c){
                if(tmp.equals("")){
                    tmp = word;
                }else if(tmp.compareTo(word) > 0){
                    tmp = word;
                }
                return true;
            }
            return false;
        }

        for(int i = 0; i < 4 ; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            // 범위를 벗어나는 경우
            if(nextX > n || nextX <= 0 || nextY > m || nextY <= 0){
                continue;
            }

            // 다음 지점에서 도착지점을 제한 횟수내에 가지 못하는 경우
            int diff = Math.abs(nextX - r) + Math.abs(nextY - c);
            if(diff % 2 != (k-1)% 2 || diff > k-1 ){
                continue;
            }

            // 이미 정렬된 알파벳 순으로 탐색을 하며 조건을 만족하는 경우 탐색을 더 진행할 이유가 없다.
            if(dfs(n,m,nextX,nextY,r,c,k-1,word.concat(addChar[i]))){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(3,4,2,3,3,1,5));
        System.out.println(solution(2,2,1,1,2,2,2));
        System.out.println(solution(3, 3, 1, 2, 3, 3, 4));
    }
}
