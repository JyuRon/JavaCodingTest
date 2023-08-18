package com.KAKAO_BLIND_RECRUITMENT_2023;
import java.util.*;

/**
 * 트리의 성질을 활용한 BruteForce
 */
public class Q04_표현_가능한_이진트리 {
    static int[] solution(long[] numbers) {
        List<Integer> tmp = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            List<Integer> binaryList = makeBinaryList(numbers[i]);

            if(available(binaryList)){
                tmp.add(1);
            }else{
                tmp.add(0);
            }
        }


        int[] answer = new int[tmp.size()];
        for(int i=0; i < tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }

    static boolean available(List<Integer> list){

        if(list.size() == 1){
            return true;
        }


        int mid = list.size() / 2;
        boolean leftCheck, rightCheck;

        // 완전트리를 기준으로 탐색하기 때문에 부모가 0인 경우 자식은 1이 될 수 없다.
        if(list.get(mid) == 0){
            for(int i = 0; i < list.size(); i++){
                if(i == mid){
                    continue;
                }

                if(list.get(i) == 1){
                    return false;
                }
            }
        }

        leftCheck = available(list.subList(0,mid));
        rightCheck = available(list.subList(mid+1,list.size()));

        return leftCheck && rightCheck;

    }

    static List<Integer> makeBinaryList(long number){
        List<Integer> binaryList = new ArrayList<>();

        while(number != 0){
            binaryList.add((int)(number % 2));
            number /= 2;
        }


        int depthCheck = binaryList.size();

        if(depthCheck <= 1){

        }else if(depthCheck <= 3){
            return addZero(binaryList, 3 - depthCheck);
        }else if(depthCheck <= 7){
            return addZero(binaryList, 7 - depthCheck);
        }else if(depthCheck <= 15){
            return addZero(binaryList, 15 - depthCheck);
        }else if(depthCheck <= 31){
            return  addZero(binaryList, 31 - depthCheck);
        }else if(depthCheck <= 63){
            return addZero(binaryList, 63 - depthCheck);
        }

        return binaryList;
    }

    static List<Integer> addZero(List<Integer> list, int size) {
        while(size-- > 0){
            list.add(0);
        }
        return list;
    }

    public static void main(String[] args) {
        long[] numbers = {63, 111, 95};
        solution(numbers);
    }
}
