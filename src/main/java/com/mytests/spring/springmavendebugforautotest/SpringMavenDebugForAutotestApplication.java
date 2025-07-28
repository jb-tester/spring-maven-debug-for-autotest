package com.mytests.spring.springmavendebugforautotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class SpringMavenDebugForAutotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMavenDebugForAutotestApplication.class, args);
    }
    @Bean @Profile( "!test")
        public CommandLineRunner commandLineRunner(TestClientService clientService) {
            return args -> {
                clientService.test1();
            };
        }
}

@RestController
@RequestMapping("/tests")
class TestController {

    @GetMapping("/test1")
    public String test1() {
        String result = "test1";
        return result;
    }
}

@Service
class TestClientService {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    RestClient.Builder builder;

    public String test1(){
        RestClient client = builder.build();
        String url = "http://localhost:" + serverPort + "/tests/test1"; // Uses the correct server port
        String result = client.get()
                .uri(url)
                .retrieve()
                .body(String.class);
        System.out.println("===== Trying /tests/test1: it returns \"" + result + "\" =====");
        return result;
    }
}