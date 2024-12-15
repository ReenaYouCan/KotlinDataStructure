package recursion.binarysearch;

import java.lang.reflect.Parameter;

public class BinarySearchRecursion {
    static int num = -1;
//if i/p is sorted bydefaukt go for binary search

    //Parameter
//start
//end
//mid

    //condition of exit
//start is greater than end
//if you find the number
    public static void main(String[] args) {
        int[] digits={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(digits,0,digits.length-1));
    }

    public static boolean binarySearch(int[] arr, int start, int end) {
        if (start > end)
            return false;
        int mid = start + (end - start) / 2;
        if (arr[mid] == num)
            return true;
        else if (num > arr[mid]) {
            return binarySearch(arr, mid+1, end);
        } else {
            return binarySearch(arr, start, mid-1);
        }

        //return false;
    }
}
