package kr.geun.oss.wbfx.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = ExampleController.class)
public class ExampleControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testEcho1() {
        this.webTestClient.get().uri("/echo")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello");
    }

}
