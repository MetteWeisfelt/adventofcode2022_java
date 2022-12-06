package days;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class DayTwo {
    public static void runChallenge1(){
        System.out.println(">>> day 2 challenge 1 is starting now...");

        File file;
        BufferedReader br;
        String line;
        String[] selection;
        int totalScore = 0;
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        scores.put("X", 1);
        scores.put("Y", 2);
        scores.put("Z", 3);

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\inputdaytwo.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                selection = line.split("\\s+");
                totalScore += scores.get(selection[1]) + getRoundPoints(selection);
            }

            System.out.println(">>> answer day two challenge 1: " + totalScore);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2(){
        System.out.println(">>> day 2 challenge 2 is starting now...");

        File file;
        BufferedReader br;
        String line;
        String[] selection;
        int totalScore = 0;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\inputdaytwo.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                selection = line.split("\\s+");

                totalScore += getPointsChallenge2(selection);
            }

            System.out.println(">>> answer day two challenge 2: " + totalScore);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static int getRoundPoints(String[] selection){
        if((selection[0].equals("A") && selection[1].equals("Y")) ||
            (selection[0].equals("B") && selection[1].equals("Z")) ||
            (selection[0].equals("C") && selection[1].equals("X"))){
            return 6;
        } else if ((selection[0].equals("A") && selection[1].equals("X")) ||
                (selection[0].equals("B") && selection[1].equals("Y")) ||
                (selection[0].equals("C") && selection[1].equals("Z"))){
            return 3;
        } else {
            return 0;
        }
    }

    static int getPointsChallenge2(String[] selection){
        int points = 0;

        switch (selection[1]) {
            case "Z" -> {
                points += 6;
                switch (selection[0]) {
                    case "A" -> points += 2;
                    case "B" -> points += 3;
                    case "C" -> points += 1;
                }
                return points;
            }
            case "Y" -> {
                points += 3;
                switch (selection[0]) {
                    case "A" -> points += 1;
                    case "B" -> points += 2;
                    case "C" -> points += 3;
                }
                return points;
            }
            case "X" -> {
                points += 0;
                switch (selection[0]) {
                    case "A" -> points += 3;
                    case "B" -> points += 1;
                    case "C" -> points += 2;
                }
                return points;
            }
        }
        return 0;
    }
}
