package kr.geun.oss.wbfx.testcase.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestCaseService.class})
public class TestCaseServiceTest {

    @Autowired
    private TestCaseService testCaseService;

    @Test
    public void fluxJustListTest() {
        Flux<String> testList = testCaseService.fluxJustList();

        StepVerifier.create(testList)
            .expectNext("Test", "Temp", "kkkk")
            .verifyComplete();
    }

    @Test
    public void fluxJustListEachTest() {
        Flux<String> testList = testCaseService.fluxJustList();

        StepVerifier.create(testList)
            .expectNext("Test")
            .expectNext("Temp")
            .expectNext("kkkk")
            .verifyComplete();
    }

    @Test
    public void fluxJustListError() {
        StepVerifier.create(testCaseService.fluxErrorTest(1))
            .verifyError(RuntimeException.class);
    }

}
