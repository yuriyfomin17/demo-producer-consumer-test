package com.demoproducer.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProducerResponseDto {
    private int field1;
    private int field2;
    private int field3;
}