package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2 "commonality
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){ //cmd left click, shows test case to review input. split; delimiter is the spacing
        //array - contains a group of whatever not a "list" because a list is a data structure
        //String array - is considered another type of string variable -
        //Assesrtion - I assert that this result is expected, and if it fails/pass
        //.split(whatever) <- tells the computer to start a new string in between whatever; ex.

        String x = input;
        int counter = 0;
        String[] strings = x.split(" ");  //regex = field names
        for (int i = 0; i < strings.length; i++) {   //fori = shortcut - access an array thru index - forLoop allows us to go thru the array under
            //condition; iterator is i. i++ = increment i+1
            //comment get word. next step --> evlauate if the words end in "y" or "z" increment to the counter
        if(strings[i].endsWith("y") || strings[i].endsWith("z")) {
            counter++; //increments to the orginal variable
        }
        }
        return counter;
    } //count the number of words ending in 'y' or 'z'; Strings can be broken down into many (characters)
    //should return the number of words ending in either y or z,

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        //given 2 strings, return the new string with all the removed based.
        //(.replace) function - takes two value, what you're replacing and what you're replacing it with
        String s = base.replace(remove, "");
        return s; //return can be made easier if, if we just 'return base.replace(remove, "");' will be quicker than
        //designating a new variable
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        //check if the input contains equal number of "is" and "not"
        //if #not = #is = true; if #not < #is return false
        int orgLength = input.length();
        int isLength = removeString(input, "is").length();
        int countIs = (orgLength - isLength) / 2;
        int notLength1 = removeString(input, "not").length();
        int countNot =(orgLength - notLength1) / 3;
        return countIs == countNot;
        //return countsOccurance(input,"is") == countsOccurance(input,"not"); - Shorthand version
    }
    public int countsOccurance(String base,String target){
//        int orgLength = input.length();
//        int isLength = removeString(input, "is").length();
//        int countIs = (orgLength - isLength) / 2;
        int baseLength = base.length();
        int newLength = removeString(base,target).length();
        return (baseLength - newLength) / target.length();
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        //g happy if it has a neighboring g; if we're currently at a g, assume we're on the first one or second one
        //or 3 one. Checkpoint idea: we only care about the g's and no g's as long as the g's fit the conditions above;
        int gCounter = 0;
        char[] newInput = input.toCharArray(); //creating an array within the original input, (shorthand)
        for (int index = 0; index < newInput.length; index = index + 1) { //newInput.Length - tells the comp to analyze the size of the array only
            char currentLetter = newInput[index];//specify a new capsule
            if (currentLetter == 'g') {//"" = denotes a string; '' denotes a character;
                gCounter++;//++gcounter - add one before reading the parameters; gcounter++ - will add one after
            } else { //we're reached a checkpoint! if conditions does not match the parameters, return false
                if(gCounter == 1)
                return false;
                else {gCounter = 0;}
            }

        }
        return true;
    }



    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1 - substring will be able to give you abc, xxx, abc
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        //similar to the test above, but instead of returning true or false. Keep count of the total triples in the
        //inputs. How to identify the array has 3 of the same characters in counts of 3, new search for the next three. abc--abc--bcd
        int tripleCounter = 0;

        for (int start = 0; start < input.length()-2; start = start + 1) {
            //.length() is a method of a string
            //subString(index piece of the string)
            String currentSequence = input.substring(start, start+3);
            // .substring(starts at the beginning of the index, ends at the given index range, but -1 position)
            char[] currentLetters = currentSequence.toCharArray(); //this variable declares that we will take the currentSequence and turn it into an array
            char firstLetter = currentLetters[0];
            //currentLetters[0] - already gets the first letter position at 0 for viewing;
            boolean allMatchingLetters = true; //title to contain if statement - this ones says all letters are the same,
            for (int position = 1; position < currentLetters.length; position++){
                //primitive data types does not need () in .length. Only if its in the class type
                if (currentLetters[position] != firstLetter) {
                    //if current position is not equal to firstLetter(current), set indicator to false
                    allMatchingLetters = false;
                    break;
                    //break - is telling the computer that if the conditions are not met, cease searching on the rest of the array;
                    //optimize way of saving time and processing
                }
            }
            if (allMatchingLetters == true){
                tripleCounter++;
            }

        }
        return tripleCounter;
    }
}
