import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Comparator;
import java.util.LinkedHashMap;

class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext() == true) {
            String input = scanner.nextLine();
            if (proccessAll(input, scanner) == false) {
                scanner.close();
                break;
            }
        }
        printProgress();
    }

    private static final int LAST_SEQUENCE = 42;
    private static final String LAST_SEQUENCE_STRING = "" + LAST_SEQUENCE;
    private static final int NUMBER_OF_WEEKS = 5;
    private static Map<List<Integer>, List<Integer>> holder = new LinkedHashMap<>();
    private static List<Integer> grades = new LinkedList<>();
    public static List<Integer> weeks = new LinkedList<>();
    public static Integer WeekCounter = 0;

    public static void printProgress() {
        for (int i = 1; i <= WeekCounter; i++) {
            int[] gradeStudent = getGradesFromMap(holder, i).stream().mapToInt(n -> n).toArray();
            System.out.print("week " + i + " ");
            visualizeStudentsProgress(gradeStudent[0]);
        }
    }

    public static boolean proccessAll(String input, Scanner scanner) {
        if (!input.equals(LAST_SEQUENCE_STRING)) {
            if (containsTarget(input, 0) && weeks.stream().findFirst().map(Collections::singletonList)
                    .orElse(Collections.emptyList()).contains(WeekCounter + 1)) {
                input = scanner.nextLine();
                int[] getGrades = new int[1];
                getGrades[0] = 0;
                if (proccesGrades(input, getGrades, 1)) {
                    grades.add(getGrades[0]);
                    List<Integer> weekNode = weeks.stream().findFirst().map(Collections::singletonList)
                            .orElse(Collections.emptyList());
                    // weeks.stream().findFirst().orElse(Collections.emptyList());
                    List<Integer> gradeNode = grades.stream().findFirst().map(Collections::singletonList)
                            .orElse(Collections.emptyList());
                    holder.put(weekNode, gradeNode);
                    weeks.clear();
                    grades.clear();
                    WeekCounter++;
                } else {
                    System.out.println("[INVALID] data input");
                    System.exit(-1);
                }
            } else {
                System.out.println("[INVALID] data input");
                System.exit(-1);
            }
        }
        if (input.equals(LAST_SEQUENCE_STRING) || WeekCounter == NUMBER_OF_WEEKS)
            return false;
        return true;
    }

    public static boolean proccesGrades(String input, int[] result, int flag) {
        input = input.trim();
        if (flag == 1 && containsTarget(input, flag) == true)
            return false;
        String[] substr = input.split("\\s+");
        if (substr.length > 5)
            return false;
        for (String current : substr) {
            try {
                Integer ifGradeValid = Integer.parseInt(current);
                result[0] += Integer.parseInt(current);
                if (ifGradeValid == 0 || !(ifGradeValid >= 1 && ifGradeValid <= 9)){
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
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

    public static void visualizeStudentsProgress(int grades) {
        int markerCount = grades;
        markerCount =  map(markerCount, 1, 45, 1, 8);
            for (int j = 0; j < markerCount; j++) {
                System.out.print("=");
            }
        System.out.println(">");
    }

    public static int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
    public static List<Integer> getGradesFromMap(Map<List<Integer>, List<Integer>> map, int week) {
        List<Integer> var = map.entrySet().stream()
                .filter(entry -> entry.getKey().contains(week))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());
        return var;
    }
}
