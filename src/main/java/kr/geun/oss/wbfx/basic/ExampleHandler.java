package kr.geun.oss.wbfx.basic;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author akageun
 */
public class ExampleHandler {

    public Mono<ServerResponse> echo(ServerRequest req) {
        return ServerResponse.ok().body(Mono.just("Hello World!!"), String.class);
    }

    public Mono<ServerResponse> echo4(ServerRequest req) {
        return ServerResponse.ok().body(BodyInserters.fromObject("Hello, " + req.pathVariable("name")));
    }
}
