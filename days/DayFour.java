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
        int count = 0;
        String line;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfour.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {
                String[] ranges = line.split(",");
                String[] elementOne = ranges[0].split("-");
                String[] elementTwo = ranges[1].split("-");

                int oneFirst = Integer.parseInt(elementOne[0]);
                int twoFirst = Integer.parseInt(elementTwo[0]);
                int oneSecond = Integer.parseInt(elementOne[1]);
                int twoSecond = Integer.parseInt(elementTwo[1]);

                if(((oneFirst <= twoFirst) && (oneSecond >= twoSecond))
                    || ((twoFirst <= oneFirst) && (twoSecond >= oneSecond))) {
                    count++;
                }
            }

            System.out.println(">>> answer day 4 challenge 1: " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runChallenge2() {
        System.out.println(">>> day 4 challenge 2 is starting now...");

        File file;
        BufferedReader br;
        String line;
        int count = 0;

        try {
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayfour.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {
                String[] ranges = line.split(",");
                String[] elementOne = ranges[0].split("-");
                String[] elementTwo = ranges[1].split("-");

                int oneFirst = Integer.parseInt(elementOne[0]);
                int twoFirst = Integer.parseInt(elementTwo[0]);
                int oneSecond = Integer.parseInt(elementOne[1]);
                int twoSecond = Integer.parseInt(elementTwo[1]);

                if (((twoFirst >= oneFirst) && (twoFirst <= oneSecond))
                    || ((twoSecond >= oneFirst) && (twoSecond <= oneSecond))){
                    count++;
                } else if (((oneFirst >= twoFirst) && (oneFirst <= twoSecond))
                    || ((oneSecond >= twoFirst) && (oneSecond <= twoSecond))){
                    count++;
                }
            }

            System.out.println(">>> answer day 4 challenge 2: " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
