package com.example.challenger.challenger3.business.converter;

import com.example.challenger.challenger3.api.dto.ResourceDTO;
import com.example.challenger.challenger3.infrastructure.entities.ResourceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ResourceConverter {

    public ResourceEntity toEntity(ResourceDTO dto){
        return ResourceEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .body(dto.getBody())
                .dataInclusao(LocalDateTime.now())
                .build();
    }

    public ResourceEntity toEntityUpdate(ResourceEntity entity ,ResourceDTO dto,Long id){
        return ResourceEntity.builder()
                .id(id)
                .title(dto.getTitle() != null ? dto.getTitle() : entity.getTitle())
                .body(dto.getBody() != null ? dto.getBody() : entity.getBody())
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public ResourceDTO toDTO(ResourceEntity entity){
        return ResourceDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .build();
    }

    public List<ResourceDTO> toListDTO(List<ResourceEntity> entityList){
        return entityList.stream().map(this::toDTO).toList();
    }





}
