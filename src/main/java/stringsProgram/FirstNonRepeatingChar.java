package stringsProgram;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , null, getFirstNonRepeatingCharacter(null));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "", getFirstNonRepeatingCharacter(""));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "fsfdsfdsf", getFirstNonRepeatingCharacter("fsfdsfdsf"));
        System.out.printf("First Non Repeating character in : %s  is : %s \n" , "I am disco dancer", getFirstNonRepeatingCharacter("I am disco dancer"));
    }


    private static Character getFirstNonRepeatingCharacter(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        char[] chars = string.toCharArray();
        boolean flag;
        Character result = null;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                flag = true;
                char matcher = chars[i];
                for (int j = i + 1; j < chars.length; j++) {
                    if (matcher == chars[j]) {
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
