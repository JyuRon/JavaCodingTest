package com.KAKAO_BLIND_RECRUITMENT_2023;

/**
 * 완전탐색
 * split("\\.") 유의!
 */
public class Q01_개인정보_수집_유효기간 {
    static int[] solution(String today, String[] terms, String[] privacies) {

        int[] tmp = new int[101];
        int[] result;

        String[] todayParse = today.split("\\.");
        int todayYear = Integer.parseInt(todayParse[0]);
        int todayMonth = Integer.parseInt(todayParse[1]);
        int todayDay = Integer.parseInt(todayParse[2]);

        int cnt = 1;
        int pointer = 0;
        for(String target : privacies){
            String[] parse = target.split(" ");

            String[] ymd = parse[0].split("\\.");
            String type = parse[1] ;

            int year = Integer.parseInt(ymd[0]);
            int month = Integer.parseInt(ymd[1]);
            int day = Integer.parseInt(ymd[2]);


            int diffYear = todayYear - year;
            int diffMonth;
            int diffDay;


            if(month > todayMonth){
                diffYear--;
                diffMonth = 12 + todayMonth - month;
            }else{
                diffMonth = todayMonth - month;
            }


            if(day > todayDay){
                diffMonth--;
                diffDay = 28 + todayDay - day;
            }else{
                diffDay = todayDay - day;
            }

            int count = diffYear * 12 * 28 + diffMonth * 28 + diffDay;


            // 약관 검사
            for(String term : terms){
                String kind = term.split(" ")[0];
                int period = Integer.parseInt(term.split(" ")[1]) * 28;

                if(kind.equals(type) && period <= count){
                    tmp[pointer++] = cnt;
                }
            }

            cnt++;
        }
        result = new int[pointer];

        for(int i=0 ; i < pointer; i++){
            result[i] = tmp[i];
        }

        return result;
    }
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies));
    }
}
