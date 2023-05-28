package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Entity.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {

	@Query(value = "SELECT reparto.*, medico.* \n" +
			"FROM reparto \n" +
			"JOIN medico ON reparto.id_medico = medico.id \n" +
			"WHERE medico.id = :medicoId", nativeQuery = true)
	Object findRepartoByMedicoId(@Param("medicoId") Integer medicoId);

}