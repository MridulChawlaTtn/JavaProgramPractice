package generalPrograms;

public class Factorial {
    public static int factorialByLoop(int n) {
        if (n == 0) {
            return 1;
        }
        else if(n<0){
            throw new ArithmeticException("The factorial of negative number is not possible.");
        }
        else {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }
            return fact;
        }
    }

    public static int factorialByRecursion(int n) {
        if (n == 0) {
            return 1;
        }
         else if(n<0){
            throw new ArithmeticException("The factorial of negative number is not possible.");
        }
        else {
            return (n * factorialByRecursion(n - 1));
        }
    }

    public static void main(String args[]) {
        int fact;
        int number = 4; //It is the number to calculate factorial
        fact = factorialByLoop(number);
        System.out.println("Factorial of " + number + " by Loop method is: " + fact);
        fact = factorialByRecursion(number);
        System.out.println("Factorial of " + number + " by Recursion method is: " + fact);
    }
}
