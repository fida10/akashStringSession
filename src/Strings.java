import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args){
        Strings main = new Strings();
        //main.stringPalindromeCheck(1, 30, 1, 100);
        main.stringSortStringDescOrder(1, 100, 1, (int) Math.pow(10, 5));
    }
    public String[] takeUserString(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        Scanner sc = new Scanner(System.in);
        int noOfTestCases;
        while(true){
            System.out.println("Enter number of test cases (strings to check)");
            noOfTestCases = sc.nextInt();
            if(noOfTestCases >= noOfTestCasesLower && noOfTestCases <= noOfTestCasesHigher){
                System.out.println("No. of test cases match constraints, continuing");
                break;
            } else {
                System.out.println("Invalid number of test cases, please try again.");
            }
        }
        String[] arrayOfStrings = new String[noOfTestCases];
        String currentString;
        int stringCounter = 0;
        while(true){
            System.out.println("Enter a string to test. This is string: " + stringCounter);
            currentString = sc.nextLine();
            int strLength = currentString.length();
            if(strLength >= noOfCharInStringLower && strLength <= noOfCharInStringHigher){
                System.out.println("Constraints met, adding to array");
                arrayOfStrings[stringCounter] = currentString;
                stringCounter++;
                if (stringCounter >= noOfTestCases){
                    System.out.println("End of String array, quitting.");
                    break;
                }
            }
            else {
                System.out.println("String entry is not within constraints, please try again");
            }
        }
        System.out.println(Arrays.toString(arrayOfStrings));
        return arrayOfStrings;
    }
    public List<String[]> takeTwoUserStrings(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        Scanner sc = new Scanner(System.in);
        int noOfTestCases;
        while(true){
            System.out.println("Enter number of test cases (strings to check)");
            noOfTestCases = sc.nextInt();
            if(noOfTestCases >= noOfTestCasesLower && noOfTestCases <= noOfTestCasesHigher){
                System.out.println("No. of test cases match constraints, continuing");
                break;
            } else {
                System.out.println("Invalid number of test cases, please try again.");
            }
        }
        String[] arrayOfStringsOne = new String[noOfTestCases];
        String[] arrayOfStringsTwo = new String[noOfTestCases];
        String[] noOfTestCasesArray = {Integer.toString(noOfTestCases)};

        List<String[]> twoArrays = new ArrayList<>();
        twoArrays.add(arrayOfStringsOne);
        twoArrays.add(arrayOfStringsTwo);
        twoArrays.add(noOfTestCasesArray);

        String currentStringOne;
        int stringCounter = 0;
        String currentStringTwo;
        while(true){
            System.out.println("Enter a string to test. This is string: " + stringCounter);
            currentStringOne = sc.next();
            System.out.println("Enter a second string to test. This is string: " + stringCounter);
            currentStringTwo = sc.next();
            int strLengthOne = currentStringOne.length();
            int strLengthTwo = currentStringTwo.length();
            boolean strLengthOneMatchesConstraints = strLengthOne >= noOfCharInStringLower && strLengthOne <= noOfCharInStringHigher;
            boolean strLengthTwoMatchesConstraints = strLengthTwo >= noOfCharInStringLower && strLengthOne <= noOfCharInStringHigher;
            if(strLengthOneMatchesConstraints && strLengthTwoMatchesConstraints){
                System.out.println("Constraints met, adding to array");
                arrayOfStringsOne[stringCounter] = currentStringOne;
                arrayOfStringsTwo[stringCounter] = currentStringTwo;
                stringCounter++;
                if (stringCounter >= noOfTestCases){
                    System.out.println("End of String array, quitting.");
                    break;
                }
            } else {
                System.out.println("String entry is not within constraints, please try again");
                System.out.println("Constraints matched: String One " + strLengthOneMatchesConstraints + "Constraints matched: String two " + strLengthTwoMatchesConstraints);
            }
        }
        return twoArrays;
    }
    public void stringPalindromeCheck(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        String[] arrayOfStrings = takeUserString(noOfTestCasesLower, noOfTestCasesHigher, noOfCharInStringLower, noOfCharInStringHigher);
        for(int i = 0; i < arrayOfStrings.length; i++){
            String currentString = arrayOfStrings[i];
            String reversedString = "";
            for(int j = currentString.length() - 1; j > - 1; j--){ //-1 in place to match j with current index on string, in reverse
                reversedString += Character.toString(currentString.charAt(j));
            }
            if(reversedString.equals(currentString)){
                System.out.println(currentString + " - Yes, String is a palindrome");
            } else {
                System.out.println(currentString + " - No, String is not a palindrome");
            }
        }
    }
    public void stringAnagram(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        List<String[]> twoArrays = takeTwoUserStrings(noOfTestCasesLower, noOfTestCasesHigher, noOfCharInStringLower, noOfCharInStringHigher);
        String[] firstString = twoArrays.get(0);
        String[] secondString = twoArrays.get(1);
        int noOfTestCases = Integer.parseInt((twoArrays.get(2))[0]);

        for (int i = 0; i < noOfTestCases; i++) {
            String currentStringOne = firstString[i];
            String currentStringTwo = secondString[i];
            System.out.println("Length of first string is: " + currentStringOne.length() + " and length of second string is: " + currentStringTwo.length());
            System.out.println("Current strings being compared: " + currentStringOne + " " + currentStringTwo);
            int secondStringOriginalLength = currentStringTwo.length();
            for(int j = 0; j < currentStringOne.length(); j++){
                if(currentStringOne.length() != secondStringOriginalLength){ //will check if strings are of the same length; if not, the outer loop will be skipped for this set of strings
                    System.out.println("Strings are not the same length, therefore they cannot be anagrams");
                    break;
                }
                String currentChar = Character.toString(currentStringOne.charAt(j));
                if(currentStringTwo.contains(currentChar)){
                    currentStringTwo = currentStringTwo.replaceFirst(currentChar, "");
                } else {
                    System.out.println(currentChar + " -- This char is not present in the second string, therefore these strings are not anagrams." );
                    break;
                }
            }
            if(currentStringTwo.equals("")){
                System.out.println("Strings are an anagram");
            } else {
                System.out.println("Strings are not an anagram");
            }
        }
    }
    public void stringAnagramPalindrome(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        String[] userStringArray = takeUserString(noOfTestCasesLower, noOfTestCasesHigher, noOfCharInStringLower, noOfCharInStringHigher);
        for (int i = 0; i < userStringArray.length; i++) {
            int oddCharCounter = 0; //this wil count the number of times a char is found to be present only once in the string. if this is more than 1, it is definitely not an anagram
            String currentString = userStringArray[i];
            boolean isAnagramPossible = true;
            for (int j = 0; j < currentString.length(); j++) {
                String charToCheck = Character.toString(currentString.charAt(j)); //geeksoskeeg --> 11 - 9 = 2
                int countOfThisChar = currentString.length() - currentString.replaceAll(charToCheck, "").length(); //takes the total length and subtract string length of string WITHOUT this char, will give us the number of occurrences of this char in the string
                if((countOfThisChar + 2) % 2 == 0){ //checks if the char repeats an even number of times. If it is odd, this statement gives 1, not 0.
                    System.out.println(charToCheck + " -- this character is present even number of times, continuing");
                    currentString = currentString.replaceAll(charToCheck, ""); //just for simplicities sake, if a letter is repeated an even number of times, it has been processed already and so can be deleted to prevent too many output statements.
                } else {
                    System.out.println(charToCheck + " -- this character is present odd number of times, adding a counter");
                    oddCharCounter++;
                    currentString = currentString.replaceAll(charToCheck, ""); // a problem occurs when this is checked; if the letter is repeated multiple times, it registers as multiple separate letters and causes the counter to go up more than once for a single letter. Therefore, odd occurrences are removed as they are found to prevent repetitions.
                }
                if(oddCharCounter > 1){ //check to see if there are an odd number of these once taking away the only one repeatable
                    System.out.println("More than one character is repeated only once, so this cannot be an anagram. Ending check for this string");
                    isAnagramPossible = false;
                    break;
                }
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ Is a palindrome possible? " + isAnagramPossible + " ~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    public void upperCaseConversion(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        String[] userStrings = takeUserString(noOfTestCasesLower, noOfTestCasesHigher, noOfCharInStringLower, noOfCharInStringHigher);
        for (int i = 0; i < userStrings.length; i++) {
            String currentString = userStrings[i];
            StringBuilder s = new StringBuilder(currentString);
            char[] firstLetter = Character.toString(currentString.charAt(0)).toUpperCase().toCharArray();
            s.setCharAt(0, firstLetter[0]); //these first few lines make sure the first letter in the string is capitalized, since there usually is no space before it
            for (int j = 0; j < currentString.length(); j++) {
                char currentChar = currentString.charAt(j);
                if(currentChar == ' '){
                    char capitalChar = Character.toString(currentString.charAt(j+1)).toUpperCase().toCharArray()[0];
                    s.setCharAt(j + 1, capitalChar); //will get the char at the index right after the space, and capitalize it, then replace the original char with the new capital char
                }
            }
            System.out.println(s);
        }
    }
    public void stringSortStringDescOrder(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        String[] userString = takeUserString(noOfTestCasesLower, noOfTestCasesHigher, noOfCharInStringLower, noOfCharInStringHigher); //this will apply constraints, directly from the user
        for (int i = 0; i < userString.length; i++) {
            String currentString = userString[i];
            String alphabeticalString = "";
            int[] stringInAsciiArray = new int[currentString.length()];
            for (int j = 0; j < currentString.length(); j++) {
                stringInAsciiArray[j] = (int) currentString.charAt(j);
            }
            //Arrays.sort(stringInAsciiArray); //all this code below can be done with this single line -_-
            List<Integer> intermediaryListOfAsciiInts = new ArrayList<Integer>(); //so i can remove elements from this later
            for (int j = 0; j < stringInAsciiArray.length; j++) {
                intermediaryListOfAsciiInts.add(j, stringInAsciiArray[j]);
            }
            int[] stringInAsciiArrayOrdered = new int[stringInAsciiArray.length];
            for (int j = 0; j < stringInAsciiArray.length; j++) {
                Integer currentMin = intermediaryListOfAsciiInts.get(0);
                int currentMinIndex = 0;
                Integer nextNo;
                for (int k = 0; k < intermediaryListOfAsciiInts.size(); k++) {
                    nextNo = intermediaryListOfAsciiInts.get(k);
                    if(nextNo < currentMin && intermediaryListOfAsciiInts.contains(nextNo)){
                        currentMin = nextNo;
                        currentMinIndex = k;
                    }
                }
                stringInAsciiArrayOrdered[j] = currentMin;
                intermediaryListOfAsciiInts.remove(currentMinIndex);
            }
            stringInAsciiArray = stringInAsciiArrayOrdered;
            //up to here, all this could be done by sort method

            for (int j = stringInAsciiArray.length - 1; j >= 0; j--) {
                alphabeticalString = alphabeticalString.concat(Character.toString(stringInAsciiArray[j]));
            }
            System.out.println(alphabeticalString);
        }
    }
}