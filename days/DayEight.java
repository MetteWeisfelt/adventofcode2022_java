package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayEight {
    public static void runChallenge1() {
        System.out.println(">>> day 8 challenge 1 is starting now...");

        String line;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayeight.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {

            }

            System.out.println(">>> answer day 8 challenge 1: ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 8 challenge 2 is starting now...");

        String line;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayeight.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {

            }

            System.out.println(">>> answer day 8 challenge 2: ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
