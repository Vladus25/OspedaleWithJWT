package com.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.PazienteEntity;

public interface PazienteRepository extends JpaRepository<PazienteEntity, Integer> {
	@Query(value = "SELECT p.id AS pazienteId, p.nome AS nomePaziente, p.cognome AS cognomePaziente, p.sesso, p.data_n, p.luogo_n, p.cod_fis AS codFisPaziente, p.id_reparto, e.id AS esameId, e.nome AS nomeEsame, " +
			"el.data AS dataEsame, el.esito AS esitoEsame, v.id AS visitaId, v.nome AS nomeVisita,vp.data AS dataVisita, vp.esito AS esitoVisita, rep.nome AS nomeReparto, m.nome AS nomeMedico, m.cognome AS cognomeMedico " +
	        "FROM paziente p " +
	        "LEFT JOIN esame_laboratorio el ON el.id_paziente = p.id " +
	        "LEFT JOIN esame e ON e.id = el.id_esame " +
	        "LEFT JOIN visita_paziente vp ON vp.id_paziente = p.id " +
	        "LEFT JOIN visita v ON v.id = vp.id_visita " +
	        "LEFT JOIN reparto rep ON rep.id = p.id_reparto " +
	        "LEFT JOIN medico m ON m.id = rep.id_medico OR m.id = vp.id_medico " +
	        "WHERE p.id = :pazienteId ", nativeQuery = true)
	List<Map<String, Object>> getDatiPaziente(@Param("pazienteId") Long pazienteId);
	
	@Query(value = "SELECT p.nome, p.cognome, el.data, el.esito " +
	        "FROM paziente p " +
	        "INNER JOIN esame_laboratorio el ON p.id = el.id_paziente " +
	        "INNER JOIN esame e ON el.id_esame = e.id " +
	        "WHERE el.data BETWEEN :dataInizio AND :dataFine " +
	        "AND e.nome = :nomeEsame ", nativeQuery = true)
	List<Map<String, Object>> getPazientiByEsameAndIntervaloTemporale(@Param("nomeEsame") String nomeEsame,  @Param("dataInizio") String dataInizio, @Param("dataFine") String dataFine);
	
	
}