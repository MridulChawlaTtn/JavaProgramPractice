package generalPrograms;

public class Factorial {
    public static void factorialByLoop(int n) {
        int i, fact = 1;
        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + n + " is: " + fact);
    }

    public static int factorialByRecursion(int n) {
        if (n == 0)
            return 1;
        else return (n * factorialByRecursion(n - 1));
    }

    public static void main(String args[]) {
        int fact;
        int number = 4; //It is the number to calculate factorial
        fact = factorialByRecursion(number);
        System.out.println("Factorial of " + number + " is: " + fact);
    }
}
