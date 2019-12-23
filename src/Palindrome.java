import java.util.Scanner;

class Palindrome {

    /**
     * Homework 1: 4th task
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isPalindrome = false;

        String wordForPalindrome = scan.next();

        // Length of s is 7
        System.out.println(wordForPalindrome);

        for(int i = 0; i < wordForPalindrome.length(); i++){
            isPalindrome = (wordForPalindrome.charAt(i) == wordForPalindrome.charAt(wordForPalindrome.length()-1-i));
            if(!isPalindrome){
                break;
            }
        }

        System.out.println("Whether the word is a Palindrome: " + isPalindrome);
    }
}

/*

Compile: javac Main.java
Run: java Main

*/
