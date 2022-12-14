package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DayThree {
    public static void runChallenge1() {
        System.out.println(">>> day 3 challenge 1 is starting now...");

        File file;
        BufferedReader br;
        String line;
        HashSet<Character> setList = new HashSet<Character>();
        int priorities = 0;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdaythree.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                for(int i = 0; i < (line.length() / 2); i++){
                    setList.add(line.charAt(i));
                }

                for(int i = (line.length() / 2); i < line.length(); i++){
                    if(setList.contains(line.charAt(i))){
                        if(Character.isUpperCase(line.charAt(i))){
                            priorities += (int) line.charAt(i) - 38;
                        } else {
                            priorities += (int) line.charAt(i) - 96;
                        }
                        break;
                    }
                }
                setList.clear();
            }

            System.out.println(">>> answer day three challenge 1: " + priorities);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 3 challenge 2 is starting now...");

        File file;
        BufferedReader br;
        String line;
        int count = 0;
        HashSet<Character> setList = new HashSet<Character>();
        HashSet<Character> dupeList = new HashSet<Character>();
        int priorities = 0;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdaythree.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                if(count == 0) {
                    for (int i = 0; i < line.length(); i++) {
                        setList.add(line.charAt(i));
                    }
                    count++;
                } else if (count == 1){
                    for (int i = 0; i < line.length(); i++) {
                        if (setList.contains(line.charAt(i))) {
                            dupeList.add(line.charAt(i));
                        }
                    }
                    count++;
                } else {
                    for (int i = 0; i < line.length(); i++){
                        if(dupeList.contains(line.charAt(i))){
                            if(Character.isUpperCase(line.charAt(i))){
                                priorities += (int) line.charAt(i) - 38;
                            } else {
                                priorities += (int) line.charAt(i) - 96;
                            }
                            dupeList.clear();
                            count = 0;
                            setList.clear();
                            break;
                        }
                    }
                }
            }

            System.out.println(">>> answer day three challenge 2: " + priorities);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
