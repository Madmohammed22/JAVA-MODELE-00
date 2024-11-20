import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;

class Program {
    private static final int LAST_SEQUENCE = 42;
    private static final String LAST_SEQUENCE_STRING = "" + LAST_SEQUENCE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> sequence = new LinkedList<>();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            sequence.add(truckOrder(input));
            if (input.equals(LAST_SEQUENCE_STRING)){
                break;
            }
        }
        System.out.println(sequence);
        scanner.close();
    }
    public static int truckOrder(String input) {
        String [] substr = input.split(" ");
        if (substr[0].equals(LAST_SEQUENCE_STRING)) {
        }
        return Integer.parseInt(substr[substr.length-1]);
    }
}