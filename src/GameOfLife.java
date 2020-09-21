import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Type in the amount of generations you want to go through!");
        int generation = scan.nextInt();

        int gridWidthLength = 25;

        //two empty 2D arrays
        int[][] grid = new int[gridWidthLength][gridWidthLength];
        int[][] gridNew = new int[gridWidthLength][gridWidthLength];

        //loop for the generation
        for (int k = 0; k <= generation; k++) {
            System.out.println();
            System.out.println("Next generation:");
            //loop row
            for (int i = 1; i < grid.length-1; i++) {
                System.out.println();
                //loop col
                for (int j = 1; j < grid[i].length-1; j++) {
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
                        if (grid[i][j] == 1) {
                            System.out.print(" * ");
                        } else {
                            System.out.print(" . ");
                        }

                        int livingNeighbourCells = 0;

                        for (int l = -1; l <= 1; l++) {
                            for (int m = -1; m <= 1; m++) {
                                livingNeighbourCells += grid[i + l][j + m];
                                livingNeighbourCells -= grid[i][j];

                                if (grid[i][j] == 0 && livingNeighbourCells == 3) {
                                    gridNew[i][j] = 1;
                                } else if (grid[i][j] == 1 && livingNeighbourCells < 2) {
                                    gridNew[i][j] = 0;
                                } else if (grid[i][j] == 1 && (livingNeighbourCells == 2 || livingNeighbourCells == 3)) {
                                    gridNew[i][j] = 1;
                                } else if (grid[i][j] == 1 && livingNeighbourCells > 3) {
                                    gridNew[i][j] = 0;
                                } else {
                                    gridNew[i][j] = grid[i][j];
                                }
                               grid[i][j] = gridNew[i][j];
                            }
                        }

                    }

                }
            }
        }

    }
}
