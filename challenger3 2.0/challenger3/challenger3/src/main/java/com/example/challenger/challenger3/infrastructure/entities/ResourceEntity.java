package com.example.challenger.challenger3.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "ResourceEntity")
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceEntity {

    @Id
    @Column(name = "id",length = 100)
    private Long id;
    @Column(name = "title",length = 100)
    private String title;
    @Column(name = "body",length = 900)
    private String body;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
