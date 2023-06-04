package com.Entity;

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
@Table(name = "reparto")
public class RepartoEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_medico", nullable = true)
	private MedicoEntity idMedico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MedicoEntity getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(MedicoEntity idMedico) {
		this.idMedico = idMedico;
	}

	public RepartoEntity(Integer id, String nome, MedicoEntity idMedico) {
		super();
		this.id = id;
		this.nome = nome;
		this.idMedico = idMedico;
	}

	public RepartoEntity() {
		super();
	}
	
	
	
}
