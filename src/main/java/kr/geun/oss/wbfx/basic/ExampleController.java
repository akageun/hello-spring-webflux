package kr.geun.oss.wbfx.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author akageun
 */
@RestController
public class ExampleController {

    @GetMapping("/echo")
    public Mono<String> routerEcho2() {
        return Mono.just("Hello");
    }
}
