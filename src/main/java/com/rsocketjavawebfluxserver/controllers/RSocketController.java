package com.rsocketjavawebfluxserver.controllers;

import com.rsocketjavawebfluxserver.entities.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class RSocketController {

    /**
     * Server Documentation:
     * https://www.paradigmadigital.com/dev/rsocket-adapta-tus-aplicaciones-era-reactiva/
     * https://rsocket.io/guides/rsocket-js/
     *
     * Client Documentation:
     * http://kojotdev.com/2019/09/rsocket-examples-java-javascript-spring-webflux/
     * https://auth0.com/blog/reactive-streams-with-kotlin-webflux-and-rsocket-js/
     * https://stackoverflow.com/questions/57993323/how-to-write-an-rsocket-client-in-javascript
     */

    @MessageMapping("fire.and.forget")
    public void handleFireAndForget(String request) {
        System.out.println(request);
    }

    @MessageMapping("request.response")
    public Message handleRequestResponse(String request) {
        System.out.println(request);
        return new Message("Hola mano");
    }

    @MessageMapping("request.stream")
    public Flux<Integer> handleRequestStream(String request) {
        System.out.println(request);
        return Flux.interval(Duration.ofSeconds(1)).map(p -> (int) (Math.random() * 100));
    }

}
