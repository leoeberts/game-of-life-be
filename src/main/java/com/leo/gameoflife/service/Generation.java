package com.leo.gameoflife.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class Generation {
    public Flux<Board> start(int intervalMs, int xLength, int yLength) {
        return Flux.just(new Board(xLength, yLength, new ConnectedEdgesEngine()))
                .flatMap(board -> Flux
                        .interval((Duration.ofMillis(intervalMs)))
                        .map(i -> board.nextGeneration())
                );
    }
}
