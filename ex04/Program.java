import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

class Program {
    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String buffer = null;
        char[] bufferChar = null;
        while (scanner.hasNextLine()) {
            buffer = scanner.nextLine();
            bufferChar = (buffer+"\n").toCharArray();
            if (containsNewLine(bufferChar) == true)
                break;
        }
        bufferChar = removeNewLine(bufferChar);
        countChars(bufferChar);
        map = map.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));        
        scanner.close();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < map(entry.getValue(), 0, 15, 0, 10); i++) {
                System.out.println("#");
            }
        }
    }

    public static boolean containsNewLine(char[] buffer){
        for (char c : buffer){
            if(c == '\n')
                return true;
        }
        return false;
    }

    public static void countChars(char[] buffer){
        for (char c : buffer){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    public static char[] removeNewLine(char[] buffer) {
        List<Character> list = new LinkedList<>();
        for (char c : buffer) {
            if (c != '\n') {
                list.add(c);
            }
        }
        char[] result = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void visualizeStudentsProgress(int grades) {
        int markerCount = grades;
        markerCount =  map(markerCount, 0, 100, 0, 10);
            for (int j = 0; j < markerCount; j++) {
                System.out.println("#");
            }
    }

    public static int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
}

/* 
 * map.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue())); // print from the highest value to the lowest
        
 */