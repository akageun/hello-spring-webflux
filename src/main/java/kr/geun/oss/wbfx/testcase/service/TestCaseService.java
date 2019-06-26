package kr.geun.oss.wbfx.testcase.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author akageun
 */
@Slf4j
@Service
public class TestCaseService {

    public Flux<String> fluxJustList() {
        return Flux.just("Test", "Temp", "kkkk");
    }

    public Flux<String> fluxErrorTest(int tmp) {
        if (tmp == 1) {
            return Flux.error(new RuntimeException("Temp Value 1"));
        }

        return Flux.just("zzzz");
    }
}
