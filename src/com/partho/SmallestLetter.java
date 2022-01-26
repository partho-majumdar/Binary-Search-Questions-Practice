package com.partho;

public class SmallestLetter {
    public static void main(String[] args) {
        char[] letter = {'c', 'f', 'j'};
        char target = 'j';
        char ans = smallLetter(letter, target);
        System.out.println("Target char " + target + " and smallest letter greater than ==> " + ans);
    }

    static char smallLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}

/*

    leetCode 744. Find The Smallest Letter Greater Than Target

    Given a characters array letters that is sorted in non-decreasing order and a character target,
    return the smallest character in the array that is larger than target.

    Note ==> that the letters wrap around.
    For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

    Example 1:
    Input: letters = ["c","f","j"], target = "a"
    Output: "c"

    Example 2:
    Input: letters = ["c","f","j"], target = "c"
    Output: "f"

    Example 3:
    Input: letters = ["c","f","j"], target = "d"
    Output: "f"

*/