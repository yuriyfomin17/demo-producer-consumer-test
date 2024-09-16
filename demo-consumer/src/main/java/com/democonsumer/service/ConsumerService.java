package com.democonsumer.service;

import com.democonsumer.dto.ConsumerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {

    private final RestTemplate restTemplate;

    @Value("${producer.port}")
    private Integer producerPort;

    public ConsumerDto testProducer() {
        return restTemplate.getForEntity("http://localhost:" + producerPort + "/producer/produce", ConsumerDto.class).getBody();
    }
}