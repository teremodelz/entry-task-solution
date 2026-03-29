package org.example.entrytasksolution.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreateProductDTO {
    @NotBlank(message = "Name can't be blank")
    @Size(max = 255, message = "Name cant exceed 255 characters.")
    private String name;

    @Size(max = 200, message = "Product cannot have more than 200 attributes")
    private Map<String, String> attributes;

    @NotNull(message = "Producer ID can't be null.")
    private Long producerId;
}
