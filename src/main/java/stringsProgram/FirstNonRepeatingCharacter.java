package stringsProgram;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , null, getFirstNonRepeatingCharacter(null));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "", getFirstNonRepeatingCharacter(""));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "fsfdsfdsf", getFirstNonRepeatingCharacter("fsfdsfdsf"));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "I am disco dancer", getFirstNonRepeatingCharacter("I am disco dancer"));
    }
    /* Using two for loops [o(n^2)] to find first non repeated character of String,
     * Algorithm :
     * Step 1 : Get character array and loop through it to make duplicate characters value as 0 on diff index values.
     * Step 2 : When getting the values of the array, check whether it's 0 or not (if 0 then don't iterate)
     * Step 3 : After iterating the full array, if for any index value there is no duplicate value present then return
     * that value to the function it was called from.
     */
    private static Character getFirstNonRepeatingCharacter(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        char[] chars = string.toCharArray();
        boolean flag = true;
        Character result = null;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        flag = false;
                        chars[j] = 0;
                    }
                }
                if (flag) {
                    result = chars[i];
                    break;
                }
            }
        }
        return result;
    }
    /* Using LinkedHashMap to find first non repeated character of String
     *  Algorithm :
     *  Step 1: Get character array and loop through it to build a hash table with char and their count.
     *  Step 2: loop through LinkedHashMap to find an entry with value 1, that's your first non-repeated character,
     *  as LinkedHashMap maintains insertion order. */
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }
    /* Finds first non repeated character in a String in just one pass.
     * It uses two storage to cut down one iteration, standard space vs time
     * trade-off.Since we store repeated and non-repeated character separately,
     * at the end of iteration, first element from List is our first non repeated character from String. */
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<Character>();
        List<Character> nonRepeating = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }
    /* Using HashMap to find first non-repeated character from String in Java.
    * Algorithm :
    * Step 1 : Scan String and store count of each character in HashMap
    * Step 2 : traverse String and get count for each character from Map.
    * Since we are going through String from first to last character,
    * when count for any character is 1, we break, it's the first non repeated character.
    * Here order is achieved by going * through String again. */

    public static char firstNonRepeatedCharacter(String word) {
        HashMap<Character, Integer> scoreboard = new HashMap<Character, Integer>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }
        // since HashMap doesn't maintain order, going through string again
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("Undefined behaviour");
    }

    //Read more: https://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html#ixzz5esEa6VNC
}
