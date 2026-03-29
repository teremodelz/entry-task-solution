package org.example.entrytasksolution.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producer")
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = "products")
@ToString(exclude = "products") @Builder
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "support_mail", length = 255, nullable = false)
    private String supportMail;
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

}
