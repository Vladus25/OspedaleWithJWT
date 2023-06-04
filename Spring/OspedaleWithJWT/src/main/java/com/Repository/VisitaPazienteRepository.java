package com.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.VisitaPazienteEntity;


public interface VisitaPazienteRepository extends JpaRepository<VisitaPazienteEntity, Integer>{
	
	@Query(value = "Select vp.data, vp.esito, v.nome AS nomeVisita, m.nome AS nomeDottore, m.cognome AS cognomeDottore "
			+ "FROM paziente p "
			+ "LEFT JOIN users u ON u.id = p.id_user "
			+ "LEFT JOIN visita_paziente vp ON vp.id_paziente = p.id "
			+ "LEFT JOIN visita v ON v.id = vp.id_visita "
			+ "LEFT JOIN medico m ON m.id = vp.id_medico "
			+ "WHERE p.id_user = :userId", nativeQuery = true)
	List<Map<String, Object>> findVisiteDelPaziente(@Param("userId") Integer userId);
}
