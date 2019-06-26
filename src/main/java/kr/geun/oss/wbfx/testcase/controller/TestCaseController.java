package kr.geun.oss.wbfx.testcase.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author akageun
 */
@RestController
public class TestCaseController {

    @GetMapping(value = "/testcase/get",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Flux<String> getTestCase() {
        return Flux.just("Test", "Temp", "kkkk");
    }
}
