package kr.geun.oss.wbfx.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author akageun
 */
@Configuration
public class ExampleRouter {

    /**
     * ExampleHandler class에 @Component 를 붙여 사용 할 수도 있음.
     *
     * @return
     */
    @Bean
    public ExampleHandler exampleHandler() {
        return new ExampleHandler();
    }

    @Bean
    public RouterFunction<ServerResponse> routeEcho(ExampleHandler exampleHandler) {
        return RouterFunctions
            .route(RequestPredicates.GET("/echo2"), exampleHandler::echo)
            .andRoute(RequestPredicates.POST("/echo3"),
                serverRequest -> ServerResponse.ok().body(Mono.just("Hello World!!"), String.class))
            .andRoute(RequestPredicates.path("/echo4/{name}"), exampleHandler::echo4);
    }
}
