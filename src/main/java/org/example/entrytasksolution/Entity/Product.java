package org.example.entrytasksolution.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entrytasksolution.Converter.JsonAttributeConverter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "product")
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(exclude = "producer")
@ToString(exclude = "producer") @Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    @Convert(converter = JsonAttributeConverter.class)
    private Map<String, String> attributes = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;
}
