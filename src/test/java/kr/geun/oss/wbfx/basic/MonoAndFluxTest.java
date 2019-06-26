package kr.geun.oss.wbfx.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author akageun
 */
@Slf4j
@RunWith(SpringRunner.class)
public class MonoAndFluxTest {

    @Test
    public void mono() {
        Mono.empty().subscribe(s -> log.info("empty() : {}", s)); //출력안됨

        Mono.just("Test Value")
            .subscribe(s -> log.info("just() : {}", s));

        Mono.error(RuntimeException::new)
            .doOnError(e -> log.error(e.getMessage(), e))
            .subscribe(s -> log.info("error() : {}", s));
    }

    @Test
    public void flux() throws InterruptedException {
        Flux.empty().subscribe(s -> log.info("empty() : {}", s)); //출력안됨
        Flux.just("value 1", "value 2", "value 3")
            .subscribe(s -> log.info("just() : {}", s));

        Flux.range(0, 10)
            .subscribe(s -> log.info("range() : {}", s));

        Flux.fromArray(new String[]{"value 1", "value 2", "value 3"})
            .subscribe(s -> log.info("fromArray() : {}", s));

        Flux.fromIterable(Arrays.asList("value 1", "value 2", "value 3"))
            .subscribe(s -> log.info("fromIterable() : {}", s));

        Flux.fromStream(IntStream.range(0, 10).boxed())
            .subscribe(s -> log.info("fromStream() : {}", s));

        Flux.interval(Duration.ofMillis(100))
            .map(item -> "tick: " + item)
            .take(10)
            .subscribe(s -> log.info("fromIterable() : {}", s));

        Thread.sleep(150);

        Flux.error(RuntimeException::new)
            .doOnError(e -> log.error(e.getMessage(), e))
            .subscribe(s -> log.info("error() : {}", s));
    }
}
