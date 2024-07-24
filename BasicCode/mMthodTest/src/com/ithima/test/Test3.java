package com.ithima.test;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 22, 55, 44};
        int[] maxAndMin = getMaxAndMin(arr);
        System.out.println(maxAndMin[0]);
        System.out.println(maxAndMin[1]);

    }
    public static int[] getMaxAndMin(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }

        int[] maxAndMin = {max, min};
        return  maxAndMin;
    }
}
