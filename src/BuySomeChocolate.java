import java.util.Scanner;

public class BuySomeChocolate {

    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;
    private static int W = 0;

    static int countMaxChoco(int money, int price) {

        // We can directly buy below number of
        // chocolates
        int choc = (int) Math.floor(money/price);

        // chocolates
        return (choc != 0) ? 1 : 0;
    }

    private static int countMaxWays(int w, int[] arr, int i, int val) {
        val += countMaxChoco(w, arr[i]);
        if(i < arr.length - 1) {
            val += countMaxChoco(w, arr[i] + arr[i+1]);
            if(i==0) {
                val += countMaxChoco(w, arr[i] + arr[i+2]);
                val += countMaxChoco(w, arr[i] + arr[i+1] + arr[i+2]);
            }
            return countMaxWays(w, arr, i +1, val);
        }
        return val;
    }

    private static int checkSumHowManyWays(int x, int y, int z, int w) {
        int[] arr = {x, y, z};
        return countMaxWays(w, arr, 0, 0);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Input the price of the white chocolate in dollars: ");
        X = scan.nextInt();
        System.out.println("Input the price of the dark chocolate in dollars: ");
        Y = scan.nextInt();
        System.out.println("Input the price of the milky chocolate in dollars: ");
        Z = scan.nextInt();
        System.out.println("Input the amount of money you have in dollars: ");
        W = scan.nextInt();

        int finalVal = BuySomeChocolate.checkSumHowManyWays(X,Y,Z,W);
        System.out.println("You can spend your money in: " + finalVal + " different ways" );

    }

}
