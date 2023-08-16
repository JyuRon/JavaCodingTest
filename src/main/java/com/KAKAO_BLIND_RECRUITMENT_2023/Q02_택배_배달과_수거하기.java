package com.KAKAO_BLIND_RECRUITMENT_2023;

/**
 * 순차탐색
 */
public class Q02_택배_배달과_수거하기 {
    static int deliveryPointer;
    static int pickUpPointer;

    static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        deliveryPointer = n -1;
        pickUpPointer = n -1;
        long answer = 0;

        while(deliveryPointer >= 0 || pickUpPointer >= 0){
            pointerCheck(deliveries, pickups);
            answer += Math.max(deliveryPointer + 1, pickUpPointer + 1) * 2;
            delivery(cap, n, deliveries);
            pickUp(cap, n, pickups);
        }


        return answer;

    }

    static void pointerCheck(int[] deliveries, int[] pickups){
        while(true){
            boolean check = true;
            if(deliveryPointer >= 0 && deliveries[deliveryPointer] == 0){
                deliveryPointer--;
                check = false;
            }

            if(pickUpPointer >= 0 && pickups[pickUpPointer] == 0){
                pickUpPointer--;
                check = false;
            }

            if(check){
                break;
            }

        }
    }

    static void delivery(int cap, int n, int[] deliveries){
        int nextCap = 0;

        while(nextCap != cap && deliveryPointer >= 0){
            if(nextCap + deliveries[deliveryPointer] > cap){
                deliveries[deliveryPointer] = deliveries[deliveryPointer] - (cap - nextCap);
                nextCap = cap;
            }else{
                nextCap += deliveries[deliveryPointer];
                deliveryPointer--;
            }
        }
    }

    static void pickUp(int cap, int n, int[] pickups){
        int nextCap = 0;

        while(nextCap != cap && pickUpPointer >= 0){
            if(nextCap + pickups[pickUpPointer] > cap){
                pickups[pickUpPointer] = pickups[pickUpPointer] - (cap - nextCap);
                nextCap = cap;
            }else{
                nextCap += pickups[pickUpPointer];
                pickUpPointer--;
            }
        }
    }

    public static void main(String[] args) {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        System.out.println(solution(cap, n, deliveries, pickups));
    }
}
