package com.example.b_Algorithm;

import java.util.*;

/**
 * Comparable, Comparator
 * 문제 1. 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오
 * 문제 2. 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제, 물건은 쪼갤 수 있음
 */
public class Section12_Greed {

    public int coin(int num){
        int count = 0;
        List<Integer> coinList = List.of(500, 100, 50, 1);

        for(Integer coin : coinList){
            System.out.println(coin + "원 : " + num/coin + "개");
            count += num / coin;
            num %= coin;
        }

        return count;
    }

    public double bag(Integer[][] objectList, double weight){

        double resultValue = 0;
        double currentWeight = 0;
        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                double targetWeightByValue = (double) o1[1] / o1[0];
                double compareWeightByValue = (double) o2[1] / o2[0];

                return (int)(targetWeightByValue - compareWeightByValue);
            }
        });

        for(Integer[] object : objectList){
            // 물품 전체를 가방에 집어 넣을 수 있는 경우
            if(weight - (currentWeight + object[0]) > 0){
                resultValue += object[1];
                currentWeight += object[0];
            // 물품 일부만 가방에 집어 넣을 수 있는 경우
            }else{
                double useWeight = weight - currentWeight;
                resultValue += (object[1] * useWeight) / object[0];
                break;
            }
        }

        return resultValue;
    }

    public static void main(String[] args) {
        Section12_Greed greed = new Section12_Greed();
        System.out.println(greed.coin(4720));

        //2차원 배열로 작성해보기 (무게, 가치)
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        System.out.println(greed.bag(objectList, 30));

        Edge edge1 = new Edge(20.0, "A");
        Edge edge2 = new Edge(10.2, "A");


        System.out.println("===== TreeSet + Comparable =====");
        Set<Edge> edgeSet = new TreeSet<>();
        edgeSet.add(edge1);
        edgeSet.add(edge2);

        for(Edge edge : edgeSet){
            System.out.println(edge);
        }


        System.out.println("===== Arrays + Comparable [정렬 전] =====");
        Edge[] arrayEdge = new Edge[]{edge1, edge2};
        for(Edge edge : arrayEdge){
            System.out.println(edge);
        }

        System.out.println("===== Arrays + Comparable [정렬 후] =====");
        Arrays.sort(arrayEdge);
        for(Edge edge : arrayEdge){
            System.out.println(edge);
        }
    }
}

