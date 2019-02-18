package stringsProgram;

import java.util.Calendar;

public class PrintFunctions {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.format("%tD", c);
    }
}
