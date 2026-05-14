package com.deliveriq.backend.repository;

import com.deliveriq.backend.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<Graph, Long> {
}
