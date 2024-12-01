import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Comparator;

class Program {
    private static final int LAST_SEQUENCE = 42;
    private static final String LAST_SEQUENCE_STRING = "" + LAST_SEQUENCE;
    private static final int NUMBER_OF_WEEKS = 5;
    private static Map<List<Integer>, List<Integer>> holder = new HashMap<>();
    private static List<Integer> grades = new LinkedList<>();
    public static List<Integer> weeks = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext() == true) {
            String input = scanner.nextLine();
            if (!input.equals(LAST_SEQUENCE_STRING)) {
                if (containsTarget(input, 0) && weeks.stream().sorted()
                                    .collect(Collectors.toList()).equals(weeks)) {
                    input = scanner.nextLine();
                    int []getGrades = new int[1];
                    getGrades[0] = 0;
                    if (proccesGrades(input, getGrades, 1)){
                        grades.add(getGrades[0]);
                    }
                    else
                        System.exit(01);
                } else
                    System.exit(01);
            }
            if (input.equals(LAST_SEQUENCE_STRING))
                break;
            holder.put(weeks, grades);
        }
        // weeks.forEach((v) -> System.out.print(v + " "));
        holder.forEach((k, v) -> System.out.println(k + " " + v));
        scanner.close();
    }

    public static boolean proccesGrades(String input, int [] result, int flag) {
        input = input.trim();
        if (flag == 1 && containsTarget(input, flag) == true)
            return false;
        String[] substr = input.split("\\s+");
        for (String current : substr)
            result[0] += Integer.parseInt(current);
        return true;
    }

    public static boolean containsTarget(String input, int flag) {
        input = input.trim();
        String[] subString = input.split("\\s+");
        if (subString.length < 2)
            return false;

        Integer number = 0;
        try {
            number = Integer.parseInt(subString[1]);
            if (flag == 0)
                weeks.add(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return subString[0].equals("week") && number > 0;
    }

    public static LinkedList<Integer> correctOrderForSequenceOfWeeks() {
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        for (int i = 0; i < NUMBER_OF_WEEKS; i++) {
            nodes.add(i);
        }
        return nodes;
    }
}