/**
 * Student: Mariam Manukyan (IESM)
 * HW1: Problem 5
 */

/**
 * Declare a class Asterix for Problem 5 solution
 */
public class AsterixProblem {

    /**
     *
     * @param i
     * @param count
     * @param altCount : count - i , we can pass it and we can also just write "(count-i)" in place of passing it
     * @param reverse
     */
    private static void drawRecursive(int i, int count, int altCount, boolean reverse) {
        /**
         * After drawing the mid line, it goes down other way, a little bit different,
         * reverse boolean is for specifying whether we passed the mid line or not
         */
        if(!reverse) {
            for (int j = 0; j < i-1; j++)
                System.out.printf("* ");
            for (int j = 0; j < (1 + count*altCount); j++)
                System.out.printf("*");
            for (int j = i - 1; j > 0; j--)
                System.out.printf(" *");
            System.out.printf("\n");
            if(i==count) {
                reverse = true;
            }
        }
        // This case works both for the upward part and also for down part of square,
        // reversed or not no matter, it should draw
        if(i!=count) {
            for (int j = 0; j < i; j++)
                System.out.printf("* ");
            for (int j = 0; j < 1 + count * (altCount - 1); j++)
                System.out.printf(" ");
            for (int j = i; j > 0; j--)
                System.out.printf(" *");
            System.out.printf("\n");
            if(!reverse && i<count) {
                // if the half has not been drawn, continue drawing
                i++;
                drawRecursive(i,count, count - i, reverse);
            }
        }
        // reverse case, after mid line
        if(reverse) {
            // if i has not reached the count, 4 in our case
            if(i!=count) {
                for (int j = 0; j < i-1; j++)
                    System.out.printf("* ");
                for (int j = 0; j < (1 + count*altCount); j++)
                    System.out.printf("*");
                for (int j = i - 1; j > 0; j--)
                    System.out.printf(" *");
                System.out.printf("\n");
            }
            i--;
            // if did not reach the last line, continue drawing
            if(i>=1) {
                drawRecursive(i, count, count - i, reverse);
            }
        }

    }

    //main method
    public static void main(String[] args) {
        /**
         * Assume we want 4 squares
         */
        int count = 4;
        // call recursive drawing method applying initial arguments
        drawRecursive(1,count, count - 1, false);
    }
}
