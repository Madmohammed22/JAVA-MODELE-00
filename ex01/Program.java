
import java.util.Scanner;

class Program{

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (printBasedOnCondition(grepIndex(number))){
            printResult(isPrime(number), grepIndex(number));
            System.exit(0);
        }
        else{
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static void printResult(boolean isPrime, int i){
        System.out.println(isPrime + " " + i);
    }

    public static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }
        for (int i = 2; i <= number / 2; i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int grepIndex(int number){
        if (number <= 1){
            return -1;
        }
        int i = 2;
        int steps = 1;
        while (i <= Math.sqrt(number)){
            if (number % i == 0){
                return steps;
            }
            steps++;
            i++;
        }
        return steps;
    }

    public static boolean printBasedOnCondition(int index){
        return index >= 0;
    }
   
}
