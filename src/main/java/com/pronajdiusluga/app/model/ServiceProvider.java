package com.pronajdiusluga.app.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ServiceProvider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;          // пр: "Auto Ivan"

    private String description;   // краток опис
    private String phone;         // контакт
    private String address;       // улица/локација

    @ManyToOne(optional = false)
    private city city;

    @ManyToOne(optional = false)
    private Category category;
}
