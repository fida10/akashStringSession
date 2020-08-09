import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args){
        Strings main = new Strings();
        //main.stringPalindromeCheck(1, 30, 1, 100);
        main.stringAnagram(1, 300, 1, (int)Math.pow(10, 6));
    }
    public String[] takeUserString(int noOfTestCasesLower, int noOfTestCasesHigher, int noOfCharInStringLower, int noOfCharInStringHigher){
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = 0;
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

        String currentString = "";
        int stringCounter = 0;
        while(true){
            System.out.println("Enter a string to test. This is string: " + stringCounter);
            currentString = sc.next();
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
        int noOfTestCases = 0;
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
            for(int j = 0; j < currentStringOne.length(); j++){
                if(currentStringOne.length() != currentStringTwo.length()){ //will check if strings are of the same length; if not, the outer loop will be skipped for this set of strings
                    System.out.println("Strings are not the same length, therefore they cannot be anagrams");
                    break;
                }
                String currentChar = Character.toString(currentStringOne.charAt(j));
                if(currentStringTwo.contains(currentChar)){
                    currentStringTwo += currentStringTwo.replace(currentChar, "");
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
}
