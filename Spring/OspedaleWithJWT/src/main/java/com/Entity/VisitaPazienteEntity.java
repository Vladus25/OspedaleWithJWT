package com.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "visita_paziente")
public class VisitaPazienteEntity {
	
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "data", nullable = false)
	private LocalDate data;
	
	@Column(name = "esito", nullable = false, length = 50)
	private String esito;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_paziente", nullable = false)
	private PazienteEntity idPaziente;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_medico", nullable = false)
	private MedicoEntity idMedico;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_visita", nullable = false)
	private VisitaEntity idVisita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public PazienteEntity getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(PazienteEntity idPaziente) {
		this.idPaziente = idPaziente;
	}

	public MedicoEntity getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(MedicoEntity idMedico) {
		this.idMedico = idMedico;
	}

	public VisitaEntity getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(VisitaEntity idVisita) {
		this.idVisita = idVisita;
	}

	public VisitaPazienteEntity(Integer id, LocalDate data, String esito, PazienteEntity idPaziente,
			MedicoEntity idMedico, VisitaEntity idVisita) {
		super();
		this.id = id;
		this.data = data;
		this.esito = esito;
		this.idPaziente = idPaziente;
		this.idMedico = idMedico;
		this.idVisita = idVisita;
	}

	public VisitaPazienteEntity() {
		super();
	}
	
	
}
