package org.example.entrytasksolution.DTOs;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UpdateProductDTO {

    @Size(max = 150, message = "Name cannot exceed 150 characters")
    private String name;

    @Size(max = 200, message = "Product cannot have more than 200 attributes")
    private Map<String, String> attributes;

    private Long producerId;
}