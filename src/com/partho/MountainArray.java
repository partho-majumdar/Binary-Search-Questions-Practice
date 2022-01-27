package com.partho;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target) {
        int peak = peakIndex(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(arr, target, peak + 1, arr.length - 1);
    }

    static int peakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }
                if (target > arr[mid]) {
                    start = mid + 1;
                }
            }
            else {
                if (target > arr[mid]) {
                    end = mid - 1;
                }
                if (target < arr[mid]) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

/*
    1095. Find in Mountain Array

    Example 1:
    Input: array = [1,2,3,4,5,3,1], target = 3
    Output: 2

    Example 2:
    Input: array = [0,1,2,4,2,1], target = 3
    Output: -1
*/