package com.itheima.mybubble;

public class MyBubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }
        }
        for (int i = 0; i < arr.length - 1 -1; i++) {
            if (arr[i] >arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }
        }
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] >arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }
        }
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] >arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }
        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");

        }
    }
}
