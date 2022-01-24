package com.partho;

public class FloorOfANumber {
    public static void main(String[] args) {
        int[] arr1 = {-5, -1, 0, 4, 6, 9, 12, 15, 21, 23, 28, 31};
        int[] arr2 = {31, 28, 24, 19, 14, 11, 7, 3, 0, -5, -9, -13};
        int target = 20;
        int ans = orderAgnostic(arr2,target);
        System.out.println("Target number is " + target + " and " + "floor number index ==> " + ans);
    }

    static int orderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isDesc = arr[start] > arr[end];

        while (start <= end) {

            int mid = (start + ((end - start) / 2));

            if (target == arr[mid]) {
                return mid;
            }

            if (isDesc) {
                if (target > arr[mid]) {
                    end = mid - 1;
                }
                else if (target < arr[mid]) {
                    start = mid + 1;
                }
            }

            else {
                if (target > arr[mid]) {
                    start = mid + 1;
                }
                else if (target < arr[mid]) {
                    end = mid - 1;
                }
            }
        }
//        return end; // for ascending
        return start; // for descending
    }
}
