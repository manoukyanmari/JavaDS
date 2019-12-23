package HW2;

import java.util.Scanner;

/**
 * Most effective solution by me: 3rd problem in HW
 */
public class NumberOfPairElements {

    // private static int count = 0;
    //Own merge sort for HALP nLOGn
    private static int sort(int[] arr, int l, int r, int count)
    {
        //int count = 0;
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            count = sort(arr, l, m, count);
            count = sort(arr , m+1, r, count);

            // Merge the sorted halves
            return sortCombineAndGetNumberOfPairsInOrder(arr, l, m, r, count);
        }
        return count;
    }

    public static int sortCombineAndGetNumberOfPairsInOrder(int[] arr, int l, int m, int r, int count)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //temporary arrays
        int L[] = new int [n1];
        int R[] = new int [n2];

        // temporary Arrays' data
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        // Initial indexes of subarrays
        int i = 0, j = 0, k = l; // k is Initial index of merged subarry array

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                count++;
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++; k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++; k++;
        }
        return count;
    };

    private static void printArray(int[] arr) {
        System.out.printf("Elements in array are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + ", ");
        }
        System.out.println("\n");
    };



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many elements will be inputted? ");

        int numberOfEl = scan.nextInt();

        System.out.println("Enter " + numberOfEl + " elements as an array Input");

        int[] arrOfEl = new int[numberOfEl];
        for (int i = 0; i < numberOfEl; i++) {
            System.out.println("Element N " + (i + 1));
            arrOfEl[i] = scan.nextInt();
        }
        printArray(arrOfEl);
        int theNumberOfPairsInOrder = sort(arrOfEl, 0, arrOfEl.length-1, 0);
        System.out.printf("Total count of number of pair of elements in order is: " + theNumberOfPairsInOrder);

    }
}
