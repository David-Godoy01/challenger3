package com.example.challenger.challenger3.business.service;

import com.example.challenger.challenger3.api.dto.ResourceDTO;
import com.example.challenger.challenger3.business.converter.ResourceConverter;
import com.example.challenger.challenger3.infrastructure.client.JsonApiClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class JsonApiService {
    private final JsonApiClient client;
    private final ResourceConverter converter;
    private final ResourceService resourceService;

    public List<ResourceDTO> findResources() {
        try {


            List<ResourceDTO> dto = client.findListResources();
            dto.forEach(resource -> {
                        Boolean retorno = resourceService.existsById(resource.getId());
                        if (retorno.equals(false)) {
                            resourceService.saveResources(converter.toEntity(resource));
                        }
                //     throw new RuntimeException(format("Recurso ja cadastrado no banco de dados", resource.getId()));
                    }
            );
            return resourceService.findAllResources();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar recursos no banco de dados");
        }
    }


  /*  public List<ResourceDTO> findResource(Long id) {
        try {


            List<ResourceDTO> dto = client.findResource();
            dto.forEach(resource -> {
                        Boolean retorno = resourceService.existsById(id);
                        if (retorno.equals(false) && id==resource.getId()) {
                            resourceService.saveResources(converter.toEntity(resource));
                        }
                        //     throw new RuntimeException(format("Recurso ja cadastrado no banco de dados", resource.getId()));
                    }
            );
            return resourceService.findAllResources();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar recursos no banco de dados");
        }

   */

    public ResourceDTO findResource(Long id) {
        try {
            if (resourceService.existsById(id)) {
                throw new RuntimeException("Recurso '"+id+"' já existe no banco de dados ");
            }

            ResourceDTO resource = client.findResource(id);

            if (resource != null  ) {
                resourceService.saveResources(converter.toEntity(resource));
            }

            return resource;
        } catch (FeignException.NotFound notFoundException) {

            System.out.println("Recurso '" +id+"' Invalido  Escolha um numero entre 1 e 100:");
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar recurso no banco de dados", e);
        }
    }


}


