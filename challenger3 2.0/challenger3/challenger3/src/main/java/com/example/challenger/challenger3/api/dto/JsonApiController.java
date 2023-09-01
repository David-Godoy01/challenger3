package com.example.challenger.challenger3.api.dto;

import com.example.challenger.challenger3.business.service.JsonApiService;
import com.example.challenger.challenger3.business.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
@Tag(name = "json-api")
public class JsonApiController {

    private final JsonApiService service;
    private final ResourceService resourceService;


    @Operation(summary = "Save resource", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @PostMapping("/{postId}")
    public ResponseEntity <ResourceDTO> saveResource(@PathVariable ("postId") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findResource(id));
    }



    @Operation(summary = "Update resources", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @PutMapping("/{postId}")
    public ResponseEntity <ResourceDTO> updateResources (@PathVariable ("postId") Long id, @RequestBody ResourceDTO dto){

        return ResponseEntity.ok(resourceService.updateResource(id, dto));
    }


    @Operation(summary = "Delete resources", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar recurso"),

    })
    @DeleteMapping("/{postId}")
    public ResponseEntity <Void> deleteResource (@PathVariable ("postId") Long id){
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Find all resources saves", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @GetMapping("")
    public ResponseEntity <List<ResourceDTO>> findAllResources (){

        return ResponseEntity.ok(resourceService.findAllResources());
    }




}
/*
   @Operation(summary = "Find all resources and save", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @PostMapping("/json")
    public ResponseEntity <List<ResourceDTO>> saveAllResources(){
        return ResponseEntity.ok(service.findResources());
    }

   */
/*
    @Operation(summary = "save news resources", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })
    @PostMapping("/")
    public ResponseEntity <ResourceDTO> saveResources(@RequestBody ResourceDTO dto){

        return ResponseEntity.ok(resourceService.saveResourceDTO(dto));
    }

     */
 /*
    @Operation(summary = "Find all for id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),

    })

    @GetMapping("/{id}")
    public ResponseEntity <ResourceDTO> findResourceById (@PathVariable ("id") Long id){

        return ResponseEntity.ok(resourceService.findById(id));
    }

     */