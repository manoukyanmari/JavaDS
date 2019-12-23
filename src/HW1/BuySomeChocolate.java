/**
 * Student: Mariam Manukyan (IESM)
 * HW1: Problem 3
 */

import java.util.Scanner;

/**
 * Here is my class for the chocolate buyers
 */
public class BuySomeChocolate {

    //prices of chocolates
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;
    //Amount of money
    private static int W = 0;

    /**
     *
     * @param money amount of money I have, price for sets, price is sent from another function for check
     * @param price the price we can pay or not via each combination of total price we send as a price to this function
     * @return
     */
    static int countMaxChoco(int money, int price) {
        // We can directly buy number of chocolates calculated below
        int choc = (int) Math.floor(money/price);
        // If my money is enough for each combination,
        // as we are counting in how many ways we can spend, if affords, ways will be 1, if not, 0
        return (choc != 0) ? 1 : 0;
    }

    private static int countMaxWays(int w, int[] arr, int i, int val) {
        //check if we can buy at least one item from passed type
        val += countMaxChoco(w, arr[i]);
        //index must be less then array length-1 ,
        //we do not want these cases for last item, cause it does not have next one, that is whay not i < arr.length
        if(i < arr.length - 1) {
            //check if we can buy passed type and next type together with money we have for all
            val += countMaxChoco(w, arr[i] + arr[i+1]);
            if(i==0) { // if we check for the first chocolate, check also when can buy:
                //first + last ones
                val += countMaxChoco(w, arr[i] + arr[i+2]);
                //3 of them
                val += countMaxChoco(w, arr[i] + arr[i+1] + arr[i+2]);
            }
            //pass val as a count of how many ways, call recursion
            return countMaxWays(w, arr, i +1, val);
        }
        return val;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //user input
        System.out.println("Input the price of the white chocolate in dollars: ");
        X = scan.nextInt();
        System.out.println("Input the price of the dark chocolate in dollars: ");
        Y = scan.nextInt();
        System.out.println("Input the price of the milky chocolate in dollars: ");
        Z = scan.nextInt();
        System.out.println("Input the amount of money you have in dollars: ");
        W = scan.nextInt();

        //make an array from my chocolate type prices
        int[] arr = {X, Y, Z};
        // call the recursive function to count ways
        int finalVal = countMaxWays(W, arr, 0, 0);
        //Show final count of ways we can spend our money on chocolates
        System.out.println("You can spend your money in: " + finalVal + " different ways" );

    }

}
