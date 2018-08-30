/******************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2018
 * Instructor: Professor Dancy
 * Section: 12 PM
 *
 * Name: Kartikeya Sharma
 * Date: 08/29/2018
 *
 * Lab / Assignment: Lab 03, Exercise 6
 *
 * Description: Recursive and iterative String methods specified in Exercise 6
 *              in Lab 03.
 *
 *****************************************/

package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) {
        // TODO - Finish this method!
        int vowelCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowelCount++;
        }
        return vowelCount;
    }

    /**
     * Count the number of vowels in a string using recursion.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowelsRec(String s) {
        // TODO - Finish this method!
        if (s.length() == 0)
            return 0;
        if ("aeiou".contains(s.substring(s.length()-1).toLowerCase()))
            return countVowelsRec(s.substring(0, s.length()-1)) + 1;
        return countVowelsRec(s.substring(0, s.length()-1));
    }

    /**
     * Check whether or not a string is a palindrome.
     *
     * @param s The string to test
     * @return True if <code>s</code> is a palindrome; otherwise,
     *         returns false
     */
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        if (s.substring(0,1).toLowerCase().equals(s.substring(s.length()-1).toLowerCase()))
            return true && isPalindrome(s.substring(1,s.length()-1));
        return false;
    }

    /**
     * Swap the first and last character in a string given its 
     * first and last characters are letters; the case is preserved during
     * the swapping. 
     *
     * @param s The string to potentially swap
     * @return The swapped string if first and last characters are letters (with
     *         case preserved) within <code>s</code>; otherwise, <code>s</code> 
     *         is returned
     */
    public static String swapLastAndFirstLetter(String s) {
        if (!Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(s.length()-1)))
            return s;
        boolean isFirstUpper = Character.isUpperCase(s.charAt(0));
        boolean isLastUpper = Character.isUpperCase(s.charAt(s.length()-1));
        String output = "";
        if (isFirstUpper)
            output += s.substring(s.length()-1).toUpperCase();
        else
            output += s.substring(s.length()-1).toLowerCase();
        output += s.substring(1,s.length()-1);
        if (isLastUpper)
            output += s.substring(0,1).toUpperCase();
        else
            output += s.substring(0,1).toLowerCase();
        return output;
    }

    /**
     * Removes all occurences of one string from another string.
     *
     * @param s The string to trim all occurences of <code>sRemove</code> from
     * @param sRemove The string occurence to trim from <code>s</code>
     * @return The trimmed string with all occurences of <code>sRemove</code>
     *         removed from <code>s</code>
     */
    public static String withoutString(String s, String sRemove) {
        return s.replace(sRemove, "");
    }

    /**
     * Calculates the sum of all of the numbers in a string.
     * @param s The string to be scanned for numbers
     * @return The sum of all of the numbers embedded within
     *         <code>s</code>
     */
    public static int sumNumbersInString(String s) {
        String[] sList = s.split("\\D");
        int sum = 0;

        for (String str : sList) {
            if (!str.equals(""))
                sum += Integer.parseInt(str);
        }
        return sum;    
    }

    /**
     * Calculates the sum of the Unicode values of all characters within
     * a string.
     * @param s The string of the characters whose Unicode values will be summed
     * @return The sum of the Unicode values of all characters within
     *         <code>s</code>
     */
    public static int addUnicodeValues(String s) {
        char[] cList = s.toCharArray();
        int sum = 0;
        for (char c : cList) {
                sum += (int) c;
        }
        return sum;
    } 

    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {

        String sTest = "Mississippi River";
        System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
        System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));

        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
        sTest = "amanapanama";
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));

        sTest = "Testing";
        System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));
        sTest = "Testing123";
        System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));

        sTest = "Testing Running Walking Jumping";
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));

        sTest = "a1b2c3";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "aa12bb34cc56dd78";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "a9D>Zc8";
        System.out.printf("addUnicodeValues(\"%s\") = %d\n", sTest, addUnicodeValues(sTest));
    }
}
