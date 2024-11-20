import java.util.Scanner;

class Program {
    private static final int LAST_SEQUENCE = 42;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCoffee = 0;
        int number = 0;
        while(scanner.hasNext()) {
            number = scanner.nextInt();
            if (isPrime(sumDigits(number))){
                countCoffee++;
            }
            if (number == LAST_SEQUENCE) {
                break;
            }
        }
        scanner.close();
        printResult(countCoffee);
    }

    public static void printResult(int countCoffee){
        System.out.println("Count of coffee-request :" + " " + countCoffee );
    }

    public static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }
        for (int i = 2; i <= number / 2; i++){
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
