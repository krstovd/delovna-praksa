package com.pronajdiusluga.app.repository;

import com.pronajdiusluga.app.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<category, Long> {
    Optional<category> findByNameIgnoreCase(String name);
}
