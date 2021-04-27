import java.util.HashMap;
import java.util.Map;

public class CashFree {

//    Given a list of n-1 integers and these integers are in the range of 1 to n and are in sorted order. There are no duplicates in the array.  Find the missing number
//    Eg [1, 2, 3, 4, 6, 7, 8]
//    Output : 5


    static int findMissing(int[] arr, int lowerIndex,int higherIndex)
    {
      // base condition
        if(arr[lowerIndex]!=(lowerIndex+1))
        {
            return arr[lowerIndex]-1;
        }

        int mid=(lowerIndex+higherIndex)/2;
        if(arr[mid]==(arr[lowerIndex])+(mid-lowerIndex))
        {
            // go to right
            //System.out.println("going right");
            return findMissing(arr, mid+1,higherIndex);

        }
        //System.out.println("going left");

        return findMissing(arr,lowerIndex,mid-1);


    }





    /*

    // Question 2
Find the length of the longest subarray with sum zero from an array of integers.
Input {

 input Array-> 15, -2, 2, -8, 1, 7, 10, 23
 sum   Array-> 15, 13, 15 7   8  15  25 48
hashmap

currentIndex- hashmapValue
min=2;

15 -> 0
13-> 1
7 ->

}
Output 5

     */

    static int maxSubArrayLength(int[] arr) {
        int size = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int sumTill = 0;
        int result = 0;
        for (int index = 0; index < size; index++) {
            sumTill += arr[index];
            if (hashMap.get(sumTill) != null) {
                // got the zero subarray
                // int intialIndex=hashMap.get(sumTill);
                if (sumTill == 0) {
                    result = index + 1;
                } else {
                    result = Math.max(result, index - hashMap.get(sumTill));
                }

            } else {
                hashMap.put(sumTill, index);
            }
        }
        return result;

    }

    public static void main(String arg[])
    {
        int arr[]=new int[]{1, 2, 3, 4, 6, 7, 8};
        int brr[]=new int[]{1, 2, 3, 4,5, 6, 7, 8,10};
        int crr[]=new int[]{ 2, 3, 4,5, 6, 7, 8};
        int subArrayProblemArray[]=new int[]{15, -2, 2, -8, 1, 7, 10, 23};

        int subArrayProblemArray2[]=new int[]{1,2,3,1,-1,0,0,0,-3,-2,-1};
        int subArrayProblemArray3[]=new int[]{ 1,2,-15,15,-15,15};


//        int x=findMissing(crr, 0,crr.length-1);
//        System.out.println(x);

        int result=maxSubArrayLength(subArrayProblemArray2);
        System.out.println(result);
//        int result2=maxSubArrayLength(subArrayProblemArray3);
//        System.out.println(result2);
    }







}
