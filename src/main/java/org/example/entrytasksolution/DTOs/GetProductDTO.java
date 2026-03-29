package org.example.entrytasksolution.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GetProductDTO {
    private Long id;
    private String name;
    private Map<String, String> attributes;
    private GetProducerDetailsDTO producer;
}
