import java.util.Scanner;

public class DivideWord {

    /**
     * Homework 1: 5th task
     * @param args
     */
    public static void main (String[] args) {
        String a;
        String b;
        Scanner scan = new Scanner(System.in);
        a = scan.next();
        System.out.println("First Word Is: " + a);

        b = a.substring(a.length()/2);
        a = a.substring(0, a.length()/2);
        System.out.println("First Word Is: " + a + " and Second Word Is: " + b);
    }
}
