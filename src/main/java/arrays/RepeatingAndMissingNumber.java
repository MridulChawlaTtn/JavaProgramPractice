package arrays;

import java.util.Arrays;

/* Given an unsorted array of size n. Array elements are in range from 1 to n.
    One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.
    E.g. arr[] = {3, 1, 3}
    Output: 1, 5  // 5 is missing and 1 occurs twice */
public class RepeatingAndMissingNumber {
    private final int repeatedNum;
    private final int missingNum;

    private RepeatingAndMissingNumber(int repeatedNum, int missingNum) {
        this.missingNum = missingNum;
        this.repeatedNum = repeatedNum;
    }

    private int getMissingNum() {
        return missingNum;
    }

    private int getRepeatedNum() {
        return repeatedNum;
    }

    /* Method 1 (Use Sorting)
    1) Sort the input array.
    2) Traverse the array and check for missing and repeating.
    3) Time Complexity: O(nLogn) */
    private static RepeatingAndMissingNumber repeatingAndMissingNumberArray(int[] num) {
        Arrays.sort(num);
        int missingNum = 0;
        int repeatedNum = 0;
        int init = 0;
        for (int i1 : num) {
            if (init == i1) {
                repeatedNum = i1;
            }
            if (init + 2 == i1) {
                missingNum = init + 1;
            }
            init = i1;
        }
        if (init < num.length) {
            missingNum = num.length;
        }
        return new RepeatingAndMissingNumber(repeatedNum, missingNum);
    }
    /* Method 2 (Use count array)
    1) Create a temp array temp[] of size n with all initial values as 0.
    2) Traverse the input array arr[], and do following for each arr[i].
    a) if(temp[arr[i]] == 0) temp[arr[i]] = 1;
    b) if(temp[arr[i]] == 1) output “arr[i]” //repeating
    3) Traverse temp[] and output the array element having value as 0 (This is the missing element)
    Time Complexity: O(n)
    Auxiliary Space: O(n) */
    public static RepeatingAndMissingNumber repeatingAndMissingNumberArray2(int[] num){
        int[] temp = new int[num.length];
        int missingNum = 0;
        int repeatedNum = 0;
        int counter =1;
        for (int i1 : num) {
            if(temp[i1-1] == 0){
                temp[i1-1] = 1;
            }
            else if(temp[i1-1] == 1){
                repeatedNum = i1;
            }
        }
        for(int i1 : temp){
            if(i1 == 0){
                missingNum = counter;
            }
            counter++;
        }
        return new RepeatingAndMissingNumber(repeatedNum, missingNum);
    }
    /*
    Method 3 (Use elements as Index and mark the visited places)
    Traverse the array. While traversing, use absolute value of every element as index and make the value at this
    index as negative to mark it visited. If something is already marked negative then this is the repeating element.
    To find missing, traverse the array again and look for a positive value.
    Time Complexity: O(n) */
    public static RepeatingAndMissingNumber repeatingAndMissingNumberArray3(int[] num){
        int missingNum = 0;
        int repeatedNum = 0;
        int i;
        for (int i1 : num) {
            //int abs_val = Math.abs(num[i]);
            if (num[i1 - 1] > 0)
                num[i1 - 1] = -num[i1 - 1];
            else
                repeatedNum = i1;
        }
        for (int i1 : num) {
            if (i1 > 0)
                missingNum = i1 + 1;
        }
        return new RepeatingAndMissingNumber(repeatedNum, missingNum);
    }
    /* Method 4 (Make two equations)
    Let x be the missing and y be the repeating element.
    1) Get sum of all numbers.
    Sum of array computed S = n(n+1)/2 – x + y
    2) Get product of all numbers.
    Product of array computed P = 1*2*3*…*n * y / x
    3) The above two steps give us two equations, we can solve the equations and get the values of x and y.
    (sum-n(n+1)/2)/((prod/n!) - 1) = miss
    (prod/n!)miss = re
    Time Complexity: O(n) */


    /* Method 5 (Use XOR)
    Let x and y be the desired output elements.
    Calculate XOR of all the array elements.
     xor1 = arr[0]^arr[1]^arr[2].....arr[n-1]
    XOR the result with all numbers from 1 to n
     xor1 = xor1^1^2^.....^n
    In the result xor1, all elements would nullify each other except x and y.
    All the bits that are set in xor1 will be set in either x or y. So if we take any set bit
    (We have chosen the rightmost set bit in code) of xor1 and divide the elements of the array in two sets –
    one set of elements with same bit set and other set with same bit not set. By doing so,
    we will get x in one set and y in another set. Now if we do XOR of all the elements in first set,
    we will get x, and by doing same in other set we will get y. */


    public static void main(String[] args) {
        RepeatingAndMissingNumber repeatingAndMissingNumber = repeatingAndMissingNumberArray3(new int[]{1, 2, 2, 3, 5});
        System.out.println("The repeating number is: " + repeatingAndMissingNumber.getRepeatedNum());
        System.out.println("The missing number is: "+repeatingAndMissingNumber.getMissingNum());
    }
}
