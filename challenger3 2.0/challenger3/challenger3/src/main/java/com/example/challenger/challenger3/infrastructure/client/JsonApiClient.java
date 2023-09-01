package com.example.challenger.challenger3.infrastructure.client;

import com.example.challenger.challenger3.api.dto.ResourceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "json-api", url = "${json-api.url:#{null}}")
public interface JsonApiClient {


    @GetMapping("/posts")
    List<ResourceDTO> findListResources();


    @GetMapping("/posts/{id}")
    ResourceDTO findResource(@PathVariable ("id") Long id);

}
