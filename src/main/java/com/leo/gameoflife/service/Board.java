package com.leo.gameoflife.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public class Board {

    @Getter
    private int[][] cells;
    private GenerationEngine engine;
    private int borderSize;

    public Board(int[][] cells, GenerationEngine engine) {
        this.cells = cells;
        this.engine = engine;
    }

    public Board(int xLength, int yLength, GenerationEngine engine) {
        this.engine = engine;
        this.cells = PopulationStater.randomStarter(xLength,yLength);
    }

    public Board(int xLength, int yLength, int borderSize, GenerationEngine engine) {
        this.engine = engine;
        this.borderSize = borderSize;
        this.cells = PopulationStater.randomStarterWithBorder(xLength, yLength, borderSize);
    }

    public Board nextGeneration() {
        this.cells = this.engine.nextGeneration(this.cells, this.borderSize);
        return this;
    }

}
