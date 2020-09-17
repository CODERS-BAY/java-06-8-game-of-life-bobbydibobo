import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Type in the amount of generations you want to go through!");
        int generation = scan.nextInt();
        int gridWidth = 25, gridLength = gridWidth;

        //two empty 2D arrays
        int[][] grid = new int[gridLength - 1][gridWidth - 1];
        int[][] gridNew = new int[gridLength - 1][gridWidth - 1];

        //loop for the generation
        for (int k = 0; k < generation; k++) {
            int gene = 0;
            gene++;
            System.out.println("Generation: " + gene);
            //loop row
            for (int i = 0; i < grid.length; i++) {
                System.out.println();
                //loop col
                for (int j = 0; j < grid.length; j++) {
                    //first gen random
                    if (k == 0) {
                        grid[i][j] = rnd.nextInt(2);
                        if (grid[i][j] == 1) {
                            System.out.print(" * ");
                        } else {
                            System.out.print(" . ");
                        }
                        //further gens not rnd
                    } else {

                        int livingNeighbourCells = 0;

                        for (int l = -1; l <= 1; l++) {
                            for (int m = -1; m <= 1; m++) {
                                livingNeighbourCells += grid[i + l][j + m];
                                livingNeighbourCells -= grid[l][m];
                                if (grid[l][m] == 0 && livingNeighbourCells == 3) {
                                    gridNew[l][m] = 1;
                                } else if (grid[l][m] == 1 && livingNeighbourCells < 2) {
                                    gridNew[l][m] = 0;
                                } else if (grid[l][m] == 1 && (livingNeighbourCells == 2 || livingNeighbourCells == 3)) {
                                    gridNew[l][m] = 1;
                                } else if (grid[l][m] == 1 && livingNeighbourCells > 3) {
                                    gridNew[l][m] = 0;
                                } else {
                                    gridNew[l][m] = grid[l][m];
                                }
                                grid[l][m] = gridNew[l][m];
                            }
                        }

                    }

                }
            }
        }

    }
}
