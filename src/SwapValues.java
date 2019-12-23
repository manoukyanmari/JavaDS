import java.util.Scanner;

public class SwapValues {

    /**
     * Homework 1: 3rd task
     * @param args
     */
    public static void main(String[] args) {
        double a;
        double b;

        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();

        System.out.println("a is " + a + " and b is " + b + "\nPress \"ENTER\" to swap the values...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Now, dears, a is " + a + " and b is " + b);
    }
}
