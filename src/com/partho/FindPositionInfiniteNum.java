package com.partho;

public class FindPositionInfiniteNum {

    public static void main(String[] args) {
        int[] infiniteArr = {-8, -5, -2, 0, 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        int ans = sizeDouble(infiniteArr, target);
        System.out.println(ans);
    }

    static int sizeDouble(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1); // here start is old start ==> new end = previous end + (size of box * 2) ==> size of box = (old end - old start + 1)
            start = temp; // here start is new start
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

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
        return -1;
    }
}

/*
    https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    01. If target element is greater than end element ih this chunk
    02. Double the size
    03. Apply Binary Search
*/