package com.partho;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr1 = {-5, -1, 0, 4, 6, 9, 12, 15, 21, 23, 28, 31};
        int[] arr2 = {31, 28, 24, 19, 14, 11, 7, 3, 0, -5, -9, -13};
        int target = 25;
        int ans = orderAgnostic(arr1, target);
        System.out.println("Target number is " + target + " and " + "Ceiling number index ==> " + ans);
    }

    static int orderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (start <= end) {
            int mid = (start + ((end - start) / 2));

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }
                else if (target > arr[mid]) {
                    start = mid + 1;
                }
                else {
                    return mid;
                }
            }

            else {
                if (target > arr[mid]) {
                    end = mid - 1;
                }
                else if (target < arr[mid]) {
                    start = mid + 1;
                }
                else {
                    return mid;
                }
            }
        }
        return start; // for ascending
        //return end // for descending
    }
}
