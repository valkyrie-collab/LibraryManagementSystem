package com.byte_trio.entity_service.repository;

import com.byte_trio.entity_service.model.EntityField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<EntityField, String> {
}
