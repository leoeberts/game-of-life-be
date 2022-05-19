package com.leo.gameoflife.service;

public class ConnectedEdgesEngine implements GenerationEngine {
    @Override
    public int countPopulation(int x, int y, int[][] current) {
        int population = 0;
        for (int xNeighbour = -1; xNeighbour < 2;  xNeighbour++) {
            for (int yNeighbour = -1; yNeighbour < 2;  yNeighbour++) {
                int xOffset = (x + xNeighbour + current.length) % current.length;
                int yOffset = (y + yNeighbour + current[0].length) % current[0].length;

                population += current[xOffset][yOffset];
            }
        }
        return population - current[x][y];
    }
}
