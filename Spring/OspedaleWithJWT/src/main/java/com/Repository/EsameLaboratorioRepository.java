package com.Repository;

import com.Entity.*;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EsameLaboratorioRepository extends JpaRepository<EsameLaboratorioEntity, Integer> {
	@Query(value = "Select pl.data, pl.esito, e.nome, e.prezzo "
			+ "FROM paziente p "
			+ "LEFT JOIN users u ON u.id = p.id_user "
			+ "LEFT JOIN esame_laboratorio pl ON pl.id_paziente = p.id "
			+ "LEFT JOIN esame e ON e.id = pl.id_esame "
			+ "WHERE p.id_user = :userId", nativeQuery = true)
	List<Map<String, Object>> findEsamiDelPaziente(@Param("userId") Integer userId);
}