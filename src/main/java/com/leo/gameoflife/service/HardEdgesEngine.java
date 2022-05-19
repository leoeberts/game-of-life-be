package com.leo.gameoflife.service;

public class HardEdgesEngine implements GenerationEngine {
    @Override
    public int countPopulation(int x, int y, int[][] current) {
        int population = 0;
        for (int xNeighbour = -1; xNeighbour < 2;  xNeighbour++) {
            for (int yNeighbour = -1; yNeighbour < 2;  yNeighbour++) {
                int xOffset = x + xNeighbour;
                int yOffset = y + yNeighbour;

                if (xOffset > -1 && xOffset < current.length && yOffset > -1 && yOffset < current[0].length) {
                    population += current[xOffset][yOffset];
                }
            }
        }
        return population - current[x][y];
    }
}
