package kr.geun.oss.wbfx.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = ExampleRouter.class)
public class ExampleRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testEcho2() {
        this.webTestClient.get().uri("/echo2")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello World!!");
    }

    @Test
    public void testEcho3() {
        this.webTestClient.post().uri("/echo3")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello World!!");
    }

    @Test
    public void testEcho4() {
        final String name = "geun";

        this.webTestClient.get().uri("/echo4/" + name)
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello, " + name);
    }

}
