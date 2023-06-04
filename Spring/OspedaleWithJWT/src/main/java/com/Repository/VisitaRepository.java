package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.VisitaEntity;

public interface VisitaRepository extends JpaRepository<VisitaEntity, Integer> {
}