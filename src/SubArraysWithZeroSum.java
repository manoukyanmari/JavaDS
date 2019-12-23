import java.util.Scanner;

public class SubArraysWithZeroSum {

    private static int numberOfElements = 0;
    private static int subsetCountSumIsZero = 0;

    private static int getSubArray(int[][] subArrays, int[] arrElems, int i, int m, int subsetCountSumIsZero) {
        for (int k = i; k < arrElems.length; k++) {
            subArrays[m][k] = arrElems[k];
        }
        int sum = 0;
        for( int q : subArrays[m]) {
            sum += q;
        }
        if(sum == 0) {
            subsetCountSumIsZero++;
        }
        i++;
        getSubArray(subArrays, arrElems, i, numberOfElements + i, subsetCountSumIsZero);
        return subsetCountSumIsZero;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many elements will be inputted? ");

        numberOfElements = scan.nextInt();

        System.out.println("Enter " + numberOfElements + " elements as an array Input");

        int subarraysLength = ((numberOfElements * (numberOfElements + 1)) / 2);
        int[] arrOfElements = new int[numberOfElements];
        int[][] subArrays = new int[subarraysLength][];
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Element N " + (i + 1));
            arrOfElements[i] = scan.nextInt();
            if(arrOfElements[i] == 0){
                subsetCountSumIsZero += 1;
            }
            subArrays[i][i] = arrOfElements[i];
        }

        subsetCountSumIsZero = getSubArray(subArrays, arrOfElements, 0, numberOfElements, subsetCountSumIsZero);

        System.out.println("The total quantity of subsets, in which sum of elements is 0 is: " + subsetCountSumIsZero);

    }

}
