package com.example.challenger.challenger3.business.service;

import com.example.challenger.challenger3.api.dto.ResourceDTO;
import com.example.challenger.challenger3.business.converter.ResourceConverter;
import com.example.challenger.challenger3.infrastructure.entities.ResourceEntity;
import com.example.challenger.challenger3.infrastructure.repositories.ResourcesRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourcesRepository repository;

    private final ResourceConverter converter;

    public ResourceEntity saveResources(ResourceEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Recurso" + e);
        }
    }

    public ResourceDTO saveResourceDTO(ResourceDTO dto) {
        try {
            ResourceEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Recurso" + e);
        }
    }

    public ResourceDTO findById(Long id) {
        try {
            if (id <= 100 && id > 0) {
                return converter.toDTO(repository.findById(id));
            }
            throw new RuntimeException(format("Erro Id invalido", id));

        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar produto por id", id), e);
        }
    }

    public List<ResourceDTO> findAllResources() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar todos produtos"), e);
        }
    }

    public void deleteResource(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar produto por id", id), e);
        }
    }

    public Boolean existsById(Long id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar produto por id", id), e);
        }

    }

    public ResourceDTO updateResource(Long id, ResourceDTO dto) {
        try {

            ResourceEntity entity = repository.findById(id);
            saveResources(converter.toEntityUpdate(entity, dto, id));
            return converter.toDTO(repository.findById(entity.getId()));
        } catch (Exception e) {
            throw new RuntimeException("Recurso nao encontrado");

        }
    }





}

