package com.mytests.spring.springmavendebugforautotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@SpringBootTest
@AutoConfigureMockRestServiceServer
@ActiveProfiles("test")
class TestClientTest {

    @Autowired
    private TestClientService testClientService;

    @Autowired
    private MockRestServiceServer mockServer;

    @Test
    void myTest() {
        mockServer.expect(requestTo("http://localhost:8081/tests/test1"))
                .andRespond(withSuccess("test1", MediaType.TEXT_PLAIN));

        String result = testClientService.test1();

        assertThat(result).isEqualTo("test1");

        mockServer.verify();
    }

}