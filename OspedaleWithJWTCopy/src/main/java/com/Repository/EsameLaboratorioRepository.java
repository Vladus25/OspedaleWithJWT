package com.Repository;

import com.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EsameLaboratorioRepository extends JpaRepository<EsameLaboratorioEntity, Integer> {
	
}