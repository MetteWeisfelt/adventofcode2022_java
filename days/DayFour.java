package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayFour {
    public static void runChallenge1() {
        System.out.println(">>> day 4 challenge 1 is starting now...");

        File file;
        BufferedReader br;


        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfour.txt");
            br = new BufferedReader(new FileReader(file));

            System.out.println(">>> answer day four challenge 1: ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 4 challenge 2 is starting now...");

        File file;
        BufferedReader br;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfour.txt");
            br = new BufferedReader(new FileReader(file));

            System.out.println(">>> answer day four challenge 2: ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
