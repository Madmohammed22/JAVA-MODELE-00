import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Program {
    private static final int LAST_SEQUENCE = 42;
    private static final String LAST_SEQUENCE_STRING = "" + LAST_SEQUENCE;
    private static final int NUMBER_OF_WEEKS = 5; 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> sequence = new LinkedList<>();
        LinkedList <Integer> nodesHolder = new LinkedList <Integer>(correctOrder());
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            sequence.add(truckOrder(input));
            if (sequence.stream.){
                System.out.println("BRAVO");
                break;
            }
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

    public static LinkedList<Integer> correctOrder(){
        LinkedList <Integer> nodes = new LinkedList<Integer>();
        for(int i = 0; i < NUMBER_OF_WEEKS; i++){
            nodes.add(i);
        }
        return nodes;
    }

}