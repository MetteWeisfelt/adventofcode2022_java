package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DaySix {
    private static final int windowSize1 = 4;
    private static final int windowSize2 = 14;

    public static void runChallenge1() {
        System.out.println(">>> day 6 challenge 1 is starting now...");

        String line;
        int marker = 0;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdaysix.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {
                ArrayList<Character> window = new ArrayList<>();

                for(int i = 0; i < windowSize1 - 1; i++){
                    window.add(line.charAt(i));
                }

                for(int i = windowSize1 - 1; i < line.length(); i++){
                    window.add(line.charAt(i));
                    int points = 0;

                    for(int k = 0; k < windowSize1; k++){
                        points += Collections.frequency(window, window.get(k));
                    }

                    if(points < windowSize1 + 1){
                        marker = i + 1;
                        break;
                    }

                    window.remove(0);
                }
            }

            System.out.println(">>> answer day 6 challenge 1: " + marker); // 3545 too high

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 6 challenge 2 is starting now...");

        String line;
        int marker = 0;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdaysix.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {
                ArrayList<Character> window = new ArrayList<>();

                for(int i = 0; i < windowSize2 - 1; i++){
                    window.add(line.charAt(i));
                }

                for(int i = windowSize2- 1; i < line.length(); i++){
                    window.add(line.charAt(i));
                    int points = 0;

                    for(int k = 0; k < windowSize2; k++){
                        points += Collections.frequency(window, window.get(k));
                    }

                    if(points < windowSize2 + 1){
                        marker = i + 1;
                        break;
                    }

                    window.remove(0);
                }
            }

            System.out.println(">>> answer day 6 challenge 2: " + marker);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
