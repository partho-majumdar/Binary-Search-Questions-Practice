package com.partho;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int ans = findPeakElement(nums);
        System.out.println(ans);
    }

    static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start + 1) / 2;

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
    162. Find Peak Element

    Example 1:
    Input: nums = [1,2,3,1]
    Output: 2

    Example 2:
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
*/