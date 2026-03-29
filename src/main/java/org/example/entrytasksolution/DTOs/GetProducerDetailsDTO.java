package org.example.entrytasksolution.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GetProducerDetailsDTO {
    private Long id;
    private String name;
    private String supportMail;

}
