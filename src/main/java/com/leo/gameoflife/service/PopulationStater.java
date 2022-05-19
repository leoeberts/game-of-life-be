package com.leo.gameoflife.service;

public class PopulationStater {

    public static int[][] randomStarter(int xLength, int yLength) {
        return randomMatrix(xLength, yLength, 0);
    }

    public static int[][] randomStarterWithBorder(int xLength, int yLength, int borderSize) {
        return randomMatrix(xLength, yLength, borderSize);
    }

    private static int[][] randomMatrix(int xLength, int yLength, int borderSize) {
        int[][] firstGeneration = new int[xLength][yLength];
        for (int x = borderSize; x < xLength - borderSize; x++) {
            for (int y = borderSize; y < yLength - borderSize; y++) {
                firstGeneration[x][y] = (int) Math.round(Math.random());
            }
        }
        return firstGeneration;
    }

    private static void setBorder(int[][] firstGeneration) {
        int xLastIndex = firstGeneration.length -1;
        int yLastIndex = firstGeneration[0].length -1;

        for (int x = 0; x <= xLastIndex; x++) {
            firstGeneration[x][0] = 0;
            firstGeneration[x][yLastIndex] = 0;
        }
        for (int y = 0; y <= yLastIndex; y++) {
            firstGeneration[0][y] = 0;
            firstGeneration[xLastIndex][y] = 0;
        }
    }
}
