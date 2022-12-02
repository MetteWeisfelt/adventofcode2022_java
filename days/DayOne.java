package days;

import java.io.*;

public class DayOne {
    public static void runChallenge1(){
        System.out.println(">>> day 1 challenge 1 is starting now...");
        File file;
        BufferedReader br;
        String line;
        int best = 0;
        int current = 0;

        try {
            file = new File("C:\\Projects\\adventofcode\\adventofcode2022\\adventofcode2022_java\\inputs\\inputdayone.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    if (current > best){
                        best = current;
                    }
                    current = 0;
                } else {
                    current = current + Integer.parseInt(line);
                }
            }

            System.out.println(">>> answer day 1 challenge 1: " + best);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2(){
        System.out.println(">>> day 1 challenge 2 is starting now...");
        File file;
        BufferedReader br;
        String line;
        int first = 0;
        int second = 0;
        int third = 0;
        int current = 0;

        try {
            file = new File("C:\\Projects\\adventofcode\\adventofcode2022\\adventofcode2022_java\\inputs\\inputdayone.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    if (current > first){
                        third = second;
                        second = first;
                        first = current;
                    } else if (current > second){
                        third = second;
                        second = current;
                    } else if (current > third){
                        third = current;
                    }
                    current = 0;
                } else {
                    current = current + Integer.parseInt(line);
                }
            }

            System.out.println(">>> answer day 1 challenge 2: " + first + second + third);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
