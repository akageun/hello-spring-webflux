package kr.geun.oss.wbfx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class HelloWbfxApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWbfxApplication.class, args);
    }

}
