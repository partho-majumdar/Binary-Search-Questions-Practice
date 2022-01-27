package com.partho;

public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        int ans = findPeakIndex(arr);
        System.out.println(ans);
    }

    static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) { // when start and end both point to the same number this will be largest number
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
}

/*
    852. Peak Index in a Mountain Array

    Example 1:
    Input: arr = [0,1,0]
    Output: 1

    Example 2:
    Input: arr = [0,2,1,0]
    Output: 1

    Example 3:
    Input: arr = [0,10,5,2]
    Output: 1

    01. arr[mid] > arr[mid+1] ==> descending part --> end = mid
    02. arr[mid] < arr[mid+1] ==> ascending part --> start = mid + 1
*/