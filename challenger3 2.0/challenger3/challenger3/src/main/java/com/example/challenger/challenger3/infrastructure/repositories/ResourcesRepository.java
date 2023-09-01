package com.example.challenger.challenger3.infrastructure.repositories;

import com.example.challenger.challenger3.infrastructure.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ResourcesRepository extends JpaRepository<ResourceEntity, String> {

    Boolean existsById(Long id);

    ResourceEntity findById (Long id);
    @Transactional
    void deleteById(Long id);
}
