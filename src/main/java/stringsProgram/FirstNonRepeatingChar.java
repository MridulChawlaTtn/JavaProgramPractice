package stringsProgram;

public class FirstNonRepeatingChar {

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
}
