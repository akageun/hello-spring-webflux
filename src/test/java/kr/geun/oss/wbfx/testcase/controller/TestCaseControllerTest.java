package kr.geun.oss.wbfx.testcase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = TestCaseController.class)
public class TestCaseControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testcaseGetTest() {
        this.webTestClient
            .get()
            .uri("/testcase/get")
            .headers(info -> info.setContentType(MediaType.APPLICATION_JSON_UTF8))
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("TestTempkkkk");
    }
}
