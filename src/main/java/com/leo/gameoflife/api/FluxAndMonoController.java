package com.leo.gameoflife.api;

import com.leo.gameoflife.service.Board;
import com.leo.gameoflife.service.Generation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@CrossOrigin(value = { "*" }, allowedHeaders = { "*" })
public class FluxAndMonoController {

    @Autowired
    private Generation generation;

    @GetMapping("/mono")
    public Mono<ResponseEntity<Response>> mono() {
        return Mono.just(ResponseEntity.ok(new Response("Hey")));
    }

    @GetMapping("/flux")
    public Flux<Integer> flux() {
        return Flux.just(1,2,3);
    }

    @GetMapping(value = "/stream", produces = APPLICATION_NDJSON_VALUE)
    public Flux<Board> stream() {
        return generation.start(60, 100, 100).log();
    }
 }

 @Data
 @AllArgsConstructor
 class Response {
    private Object value;
 }