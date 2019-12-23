/**
 * Student: Mariam Manukyan (IESM)
 * HW1: Problem 6
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Class "FindTheWord" for Problem 6 implementation:
 */
public class FindTheWord {

    // declare an initial variable for checking if we have a word in square
    private static boolean checkIfWeHave = false;

    //main method
    public static void main(String[] args) {
        // Used internal Random, imported it above
        Random rnd = new Random();

        //Used Scanner for user input, imported above
        Scanner scan = new Scanner(System.in);

        //Create a multidimesional 4x4 array, like described, in my case by random for better testing
        char squareTable[][] = new char [4][4];

        String arrOfCharsAsString = "";  //Will be a string containing letters in array

        //fill each cell of the table going through it looping
        for (int i = 0; i < squareTable.length; i++) {
            for (int j = 0; j < squareTable[i].length; j++) {
                char c = (char) (rnd.nextInt(26) + 'a'); //random letter, char type
                squareTable[i][j] = c; // fill array cell
                arrOfCharsAsString += String.valueOf(c); //have all the letters in string
                System.out.printf(String.valueOf(squareTable[i][j])); //for our vision
            }
            System.out.println("\n"); //for our vision
        }

        //User part
        System.out.println("Please, assert some word to check if it can be formulated by the table letters: ");
        String word = scan.next(); //user inputs some word
        System.out.println("Now we will check if we have matches for the word: " + word ); //message

        // functional part: call of the function to check the possibilities
        checkIfWeHave = checkAllThePossibilities(word, arrOfCharsAsString, squareTable);
        //After final check it goes to this line showing appropriate information to user
        String answer = checkIfWeHave ? "YES, You can form the word" : "No, dear, form another word:";
        System.out.println(answer);  //for our vision
    }

    /**
     *
     * @param word This is a word user inputted
     * @param arrOfCharsAsString This is the 16 letters generated randomly
     * @param squareTable this is our table
     * @return
     */
    private static boolean checkAllThePossibilities(String word, String arrOfCharsAsString, char[][] squareTable) {

        char[] wordArr = word.toCharArray(); // Split our word making an array of chars to loop through

        //Step 1:
        //Check if we have all the letters written
        for(int k=0; k<wordArr.length;k++){ //loop through the letters in word
            checkIfWeHave = (arrOfCharsAsString.indexOf(String.valueOf(wordArr[k]))!=-1);
            if(!checkIfWeHave){
                // If we don't have any, just return the false, don't continue
                return checkIfWeHave;
            }
        }
        //Step2:
        // If we have all the letters, let us loop through our word array to find the index of first letter in it:
        for(int k=0; k<wordArr.length - 1;k++){
            for ( int i = 0; i < squareTable.length - 1; i++ ) {
                for ( int j = 0; j < squareTable[i].length - 1; j++ ) {
                    // Find the Index of first Letter
                    if ( squareTable[i][j] == wordArr[k] ) {
                        //Step 3: call a loop to check possibilities passing the arguments and get the return value
                        checkIfWeHave = startLooping(squareTable, i, j, wordArr, k);
                    }
                }
            }
        }
        //return final value
        return checkIfWeHave;
    }

    /**
     *
     * @param squareTable randomly generated multidimensional array
     * @param i index for i, from which we initialize loop each time
     * @param j index for j, from which we initialize loop each time :
     *         i and j are last checked letter's positions in squareTable array
     * @param wordArr The word user inputted, we made it array to work with it
     * @param letterIndex last checked letter's index in word
     * @return
     */
    private static boolean startLooping(char[][] squareTable, int i, int j, char[] wordArr, int letterIndex) {
        //check next letter
        int checkIndex = letterIndex + 1;
        //whether exists above, below, to the right or left

        if(checkIndex < wordArr.length - 1) {
            int initialXIndex = i; //initial X becomes the one we pass to loop each time
            int initialYIndex = j; //initial Y becomes the one we pass to loop each time

            //check for index to fit the scope, not go outside table boundaries
            if(j+1 < squareTable[i].length - 1 && squareTable[i][j+1] == wordArr[checkIndex]) {  //check if is to the right
                initialYIndex = j+1; //If is to the right, change position of next element to pass to loop
            } else if(j-1 > 0 && squareTable[i][j-1] == wordArr[checkIndex]) { //check if is to the left
                initialYIndex = j-1; //If is to the left, change position of next element to pass to loop
            } else if(i-1 > 0 && squareTable[i-1][j] == wordArr[checkIndex]) { //check if is above the left
                initialXIndex = i-1; //If is to the above, change position of next element to pass to loop
            } else if(i+1< squareTable.length - 1  && squareTable[i+1][j] == wordArr[checkIndex]) { //check if is below the left
                initialXIndex = i+1; //If is below, change position of next element to pass to loop
            } else {
                // If is not above, below, to the right and to the left, then we can not form word
                checkIfWeHave = false;
                // return false as value here, as we can't create a word
                return checkIfWeHave;
            }
            //if there is appropriate letter, check is passed, then, continue,
           if(checkIfWeHave) {
               // pass next index to check whether next letter is located:
               // above, below, right or left to already checked one
               startLooping(squareTable, initialXIndex, initialYIndex, wordArr, checkIndex);
            }
        }
        //return final result
        return checkIfWeHave;
    };

}
