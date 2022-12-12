package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class DayFive {
    static ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
    static ArrayList<Stack<Character>> tempStacks = new ArrayList<Stack<Character>>();
    private static final int numCrates = 9;

    public static void runChallenge1() {
        System.out.println(">>> day 5 challenge 1 is starting now...");

        String line;
        int spaces = 0;
        int previousCrates = 0;
        boolean reversed = false;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfive.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            for(int i = 0; i < numCrates; i++){
                tempStacks.add(new Stack<Character>());
                stacks.add(new Stack<Character>());
            }

            while((line = br.readLine()) != null) {
                for(int i = 0; i < line.length() ;i++){
                    if(line.startsWith("move")){
                        if(!reversed){
                            reverseStacks();
                            reversed = true;
                        }

                        String[] moves = line.split("\\s+");
                        makeMove(Integer.parseInt(moves[1]), (Integer.parseInt(moves[3]) - 1), (Integer.parseInt(moves[5]) - 1));
                        break;
                    } else if(Character.isLetter(line.charAt(i))){
                        int k = (int) (previousCrates + (spaces / 4)); //math.ceil?
                        tempStacks.get(k).add(line.charAt(i));
                    } else if (line.charAt(i) == ']'){
                        previousCrates++;
                        spaces--;
                    } else if (line.charAt(i) == ' '){
                        spaces++;
                    }
                }

                previousCrates = 0;
                spaces = 0;
            }

            ArrayList<Character> word = calculateCrates();

            System.out.println(">>> answer day 5 challenge 1: " + word);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reverseStacks(){
        for(int i = 0; i < numCrates; i++){
            int size = tempStacks.get(i).size();
            for(int j = 0; j < size; j++){
                stacks.get(i).push(tempStacks.get(i).pop());
            }
        }
    }

    private static ArrayList<Character> calculateCrates(){
        ArrayList<Character> word = new ArrayList<Character>();
        for(int i = 0; i < numCrates; i++){
            word.add(stacks.get(i).pop());
        }
        return word;
    }

    private static void makeMove(int amount, int from, int to){
        for(int i = 0; i < amount; i++){
            stacks.get(to).push(stacks.get(from).pop());
        }
    }

    private static void makeMove2(int amount, int from, int to){
        Stack<Character> reversedCrateOrder = new Stack<Character>();
        for(int i = 0; i < amount; i++){
            reversedCrateOrder.push(stacks.get(from).pop());
        }

        for(int j = 0; j < amount; j++){
            stacks.get(to).push(reversedCrateOrder.pop());
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 5 challenge 2 is starting now...");

        String line;
        int spaces = 0;
        int previousCrates = 0;
        boolean reversed = false;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfive.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            tempStacks.clear();
            stacks.clear();

            for(int i = 0; i < numCrates; i++){
                tempStacks.add(new Stack<Character>());
                stacks.add(new Stack<Character>());
            }

            while((line = br.readLine()) != null) {
                for(int i = 0; i < line.length() ;i++){
                    if(line.startsWith("move")){
                        if(!reversed){
                            reverseStacks();
                            reversed = true;
                        }

                        String[] moves = line.split("\\s+");
                        makeMove2(Integer.parseInt(moves[1]), (Integer.parseInt(moves[3]) - 1), (Integer.parseInt(moves[5]) - 1));

                        break;
                    } else if(Character.isLetter(line.charAt(i))){
                        int k = (int) (previousCrates + (spaces / 4)); //math.ceil?
                        tempStacks.get(k).add(line.charAt(i));
                    } else if (line.charAt(i) == ']'){
                        previousCrates++;
                        spaces--;
                    } else if (line.charAt(i) == ' '){
                        spaces++;
                    }
                }

                previousCrates = 0;
                spaces = 0;
            }

            ArrayList<Character> word = calculateCrates();

            System.out.println(">>> answer day 5 challenge 2: " + word);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
