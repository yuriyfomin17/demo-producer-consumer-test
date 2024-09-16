package com.democonsumer.service;

import com.democonsumer.dto.ConsumerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com:demo-producer:+:stubs:6565"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ConsumerServiceTest {

    @StubRunnerPort("demo-producer")
    int producerPort;

    @Autowired
    ConsumerService consumerService;

    @BeforeEach
    public void setUpPort() {
        ReflectionTestUtils.setField(consumerService, "producerPort", producerPort);
    }

    @Test
    void shouldReturnRequiredConsumerDtoField() {
        // when
        ConsumerDto consumerDto = consumerService.testProducer();
        // then
        Assertions.assertEquals(consumerDto.field1(), 1);
        Assertions.assertEquals(consumerDto.field2(), 2);
        Assertions.assertEquals(consumerDto.field3(), 3);

    }
}
