package com.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medico")
public class MedicoEntity {
	
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "data_n", nullable = false)
    private LocalDate dataN;

    @Column(name = "luogo_n", nullable = false, length = 50)
    private String luogoN;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataN() {
		return dataN;
	}

	public void setDataN(LocalDate dataN) {
		this.dataN = dataN;
	}

	public String getLuogoN() {
		return luogoN;
	}

	public void setLuogoN(String luogoN) {
		this.luogoN = luogoN;
	}

	public MedicoEntity(Integer id, String cognome, String nome, LocalDate dataN, String luogoN) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.dataN = dataN;
		this.luogoN = luogoN;
	}

	public MedicoEntity() {
		super();
	}
    
    
}
