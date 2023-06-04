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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "paziente")
public class PazienteEntity {
	
	@Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "data_n", nullable = true)
    private LocalDate dataN;

    @Column(name = "luogo_n", nullable = true, length = 50)
    private String luogoN;

    @Column(name = "sesso", nullable = true, length = 1)
    private String sesso;

    @Column(name = "cod_fis", nullable = false, length = 16)
    private String codFis;

    @Column(name = "data_ricovero", nullable = true)
    private LocalDate dataRicovero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reparto")
    private RepartoEntity idReparto;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity idUser;
    
    
    @Column(name = "file", columnDefinition = "LONGBLOB")
    private byte[] file;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	public LocalDate getDataRicovero() {
		return dataRicovero;
	}

	public void setDataRicovero(LocalDate dataRicovero) {
		this.dataRicovero = dataRicovero;
	}

	public RepartoEntity getIdReparto() {
		return idReparto;
	}

	public void setIdReparto(RepartoEntity idReparto) {
		this.idReparto = idReparto;
	}
	
	public void setIdUser(UserEntity idUser) {
		this.idUser = idUser;
	}

	public PazienteEntity() {
		super();
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public PazienteEntity(Integer id, String nome, String cognome, LocalDate dataN, String luogoN, String sesso,
			String codFis, LocalDate dataRicovero, RepartoEntity idReparto, UserEntity idUser, byte[] file) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataN = dataN;
		this.luogoN = luogoN;
		this.sesso = sesso;
		this.codFis = codFis;
		this.dataRicovero = dataRicovero;
		this.idReparto = idReparto;
		this.idUser = idUser;
		this.file = file;
	}

	public UserEntity getIdUser() {
		return idUser;
	}

}
