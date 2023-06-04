package com.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.PazienteEntity;

public interface PazienteRepository extends JpaRepository<PazienteEntity, Integer> {
	
	@Query(value = "SELECT p.id AS pazienteId, p.nome AS nomePaziente, p.cognome AS cognomePaziente, p.sesso, p.data_n, p.luogo_n, p.data_ricovero, p.cod_fis AS codFisPaziente, p.id_reparto, p.file, rep.nome AS nomeReparto " +
	        "FROM paziente p " +
	        "LEFT JOIN reparto rep ON rep.id = p.id_reparto " +
	        "LEFT JOIN users u ON u.id = p.id_user " +
	        "WHERE p.id_user = :userId ", nativeQuery = true)
	List<Map<String, Object>> getDatiPaziente(@Param("userId") Long userId);
	
}