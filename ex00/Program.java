
class Program {
    private static final int LAST_SEQUENCE = 42;

    public static void main(String[] args) {
        int SUM_DIGITS = 479598;
        printResult(sumDigits(SUM_DIGITS));
    }

    public static void printResult(int sumDigits) {
        System.out.println(sumDigits);
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