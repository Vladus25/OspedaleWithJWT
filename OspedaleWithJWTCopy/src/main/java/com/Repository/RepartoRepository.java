package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.RepartoEntity;

public interface RepartoRepository extends JpaRepository<RepartoEntity, Integer> {
}