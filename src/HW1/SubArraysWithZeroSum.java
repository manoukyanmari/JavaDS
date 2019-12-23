/**
 * Student: Mariam Manukyan (IESM)
 * HW1: Problem 4
 */

import java.util.Scanner;

/**
 * Create a Class SubArraysWithZeroSum for the problem 4 solution
 */
public class SubArraysWithZeroSum {

    //number of elements user will input
    private static int numberOfElements = 0;
    //Declare a variable, defining how many subsets we have, so that sum of elements in each is 0
    private static int subsetCountSumForZero = 0;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("How many elements will be inputted? ");
        numberOfElements = scan.nextInt();
        //User decides how many elements will input
        System.out.println("Enter " + numberOfElements + " elements as an array Input");
        int[] arrOfElements = new int[numberOfElements];
        // User will input values for each element
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Element N " + (i + 1));
            arrOfElements[i] = scan.nextInt();
        }
        //call the function, which is written recursively
        subsetCountSumForZero = getSubArray(arrOfElements, 0);
        System.out.println("The total quantity of subsets, in which sum of elements is 0 is: " + subsetCountSumForZero);

    }

    /**
     *
     * @param initialArray : each time passed initial array, from where we should start, firstly it is our whole array
     * @param m position count starting from 0 and looping till the last element of an array]
     * @return
     */
    private static int getSubArray(int[] initialArray, int m) {
        //Subarray substracts first index each time loop is being called, and becomes smaller
        int[] subArray = new int[initialArray.length - m];
        int sum = 0;
        // Loop through empty subarray to build it firstly
        for (int i=0; i < subArray.length; i++) {
            //Subarray's 0 element is initali's 1st by index and so on
            subArray[i] = initialArray[i + m]; //fill the subarray with the set
            //each time, starting from the first number we have,
            // we add up sum, to understand as soon as it becomes zero, as a contiguous portion
            //on each iteration of recursion this will start from next number, so we will not miss anything
            sum += subArray[i];
            if(sum == 0) {
                subsetCountSumForZero++;
            }
            System.out.println("The total Sum of subarray items is subsetCountSum: " + subsetCountSumForZero);
            System.out.println("The total Sum of subarray items is: " + sum);
        }
        //If we have not reached the last element on looping
        if(m < initialArray.length - 1) {
            // change position of set 1 point to the right,
            m++;
            //Example: if it was -6,4,5 above , it will start from 4,5 now (from index of 4)
            getSubArray(initialArray, m);
        }
        //return the final count
        return subsetCountSumForZero;
    }

}
