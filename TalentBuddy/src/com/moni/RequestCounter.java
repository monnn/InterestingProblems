package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class RequestCounter {

    public static void countRequests(Integer[] requests, Integer[] proStart, Integer[] proEnd) {
        Integer[] workTime = new Integer[proStart.length];
        for (int k = 0; k < workTime.length; k++) {
            workTime[k] = 0;
        }
        for (int i = 0; i < proStart.length ; i++) {
            for (int j = 0; j < requests.length; j++) {
                if (proStart[i] <= requests[j] && proEnd[i] >= requests[j]){
                    workTime[i] = workTime[i] + 1;
                }
            }
        }
        for (int i = 0; i < workTime.length; i++) {
            System.out.println(workTime[i]);
        }
    }

    public static void main(String[] args){
        Integer[] req = {6, 5, 2, 3};
        Integer[] start = {1, 4};
        Integer[] end = {5, 6};
        countRequests(req, start, end);
    }
}
