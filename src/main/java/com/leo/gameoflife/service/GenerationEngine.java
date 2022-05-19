package com.leo.gameoflife.service;

public interface GenerationEngine {

    int countPopulation(int x, int y, int[][] current);

    default int[][] nextGeneration(int[][] current, int borderSize) {
        int[][] newBoard = new int[current.length][current[0].length];

        for (int x = borderSize; x < current.length - borderSize; x++) {
            for (int y = borderSize; y < current[0].length - borderSize; y++) {
                int population = countPopulation(x, y, current);

                if (population == 3) {
                    //Any dead cell with three live neighbours becomes a live cell.
                    newBoard[x][y] = 1;
                } else if (current[x][y] == 1 && (population < 2 || population > 3)) {
                    //Any live cell with two or three live neighbours survives.
                    newBoard[x][y] = 0;
                } else {
                    //All other live cells die in the next generation. Similarly, all other dead cells stay dead.
                    newBoard[x][y] = current[x][y];
                }
            }
        }

        return newBoard;
    }
}
