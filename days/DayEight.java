package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayEight {
    static int[][] grid = new int[99][99];

    public static void runChallenge1() {
        System.out.println(">>> day 8 challenge 1 is starting now...");

        String trees;
        int currentRow = 0;
        int visibleTrees = 0;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayeight.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((trees = br.readLine()) != null) {
                for(int column = 0; column < trees.length(); column++){
                    grid[currentRow][column] = Integer.parseInt(String.valueOf(trees.charAt(column)));
                }
                currentRow++;
            }

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(isVisible(i, j)){
                        visibleTrees++;
                    }
                }
            }

            System.out.println(">>> answer day 8 challenge 1: " + visibleTrees);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isEdge(int row, int column){
        return (row == 0 || row == grid.length - 1 || column == 0 || column == grid[0].length - 1);
    }

    private static boolean isVisible(int row, int column){

        if(!isEdge(row, column)){
            // check if left side lower
            for(int i = column - 1; i >= 0; i--){
                if(grid[row][i] >= grid[row][column]){
                    break;
                } else if(i == 0){
                    return true;
                }
            }

            // check if right side lower
            for(int i = column + 1; i < grid[row].length; i++){
                if(grid[row][i] >= grid[row][column]){
                    break;
                } else if (i == grid[row].length - 1){
                    return true;
                }
            }

            // check if top lower
            for(int i = row - 1; i >= 0; i--){
                if(grid[i][column] >= grid[row][column]){
                    break;
                } else if (i == 0){
                    return true;
                }
            }

            // check if bottom lower
            for(int i = row + 1; i < grid.length; i++){
                if(grid[i][column] >= grid[row][column]){
                    break;
                } else if (i == grid.length - 1){
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    private static int calculateScenicScore(int row, int column){
        int scenicPoints = 0;
        int maxHeight = grid[row][column];
        int totalScore = 1;

        // check if left side lower
        for(int i = column - 1; i >= 0; i--){
            scenicPoints++;
            if(grid[row][i] >= maxHeight){
                break;
            }
        }

        totalScore *= scenicPoints;
        scenicPoints = 0;

        // check if right side lower
        for(int i = column + 1; i < grid[0].length; i++){
            scenicPoints++;
            if(grid[row][i] >= maxHeight){
                break;
            }
        }

        totalScore *= scenicPoints;
        scenicPoints = 0;

        // check if top lower
        for(int i = row - 1; i >= 0; i--){
            scenicPoints++;
            if(grid[i][column] >= grid[row][column]){
                break;
            }
        }

        totalScore *= scenicPoints;
        scenicPoints = 0;

        // check if bottom lower
        for(int i = row + 1; i < grid.length; i++){
            scenicPoints++;
            if(grid[i][column] >= grid[row][column]){
                scenicPoints++;
                break;
            }
        }

        totalScore *= scenicPoints;

        return totalScore;
    }

    public static void runChallenge2() {
        System.out.println(">>> day 8 challenge 2 is starting now...");

        String trees;
        int currentRow = 0;

        try {
            File file = new File("C:\\Users\\mcwei\\Documents\\Personal\\Projects\\adventofcode2022\\inputs\\inputdayeight.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((trees = br.readLine()) != null) {
                for(int column = 0; column < trees.length(); column++){
                    grid[currentRow][column] = Integer.parseInt(String.valueOf(trees.charAt(column)));
                }
                currentRow++;
            }

            int bestScore = 0;

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    int scenicScore = calculateScenicScore(i, j);

                    if(scenicScore > bestScore){
                        bestScore = scenicScore;
                    }
                }
            }

            System.out.println(">>> answer day 8 challenge 2: " + bestScore);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
