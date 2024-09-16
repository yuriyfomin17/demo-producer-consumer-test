package com.demoproducer.rest;

import com.demoproducer.dto.ProducerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {


    @GetMapping("/produce")
    public ResponseEntity<ProducerResponseDto> getResponse() {
        return ResponseEntity.ok(
                ProducerResponseDto.builder()
                        .field1(1)
                        .field2(2)
                        .field3(3)
                        .build()
        );
    }
}