package br.com.fnde.educacao.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="timeline")
public class TimeLine implements Domain {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idTimeLine", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTimeLine;
	
	@Column(name="idEscola", nullable=false) 
	private Long idEscola;
	
	@Column(name="noFaceBook", nullable=false, length=100)
	private String noFaceBook;
	
	@Column(name="fotoFaceBook", nullable=false, length=5000)
	private String fotoFaceBook;
	
	@NotNull	
	@Column(name="tpTimeLine", nullable=false) 
	private Integer tpTimeLine;
	
	@NotNull
	@Column(name="dtTimeLine", nullable=false) 
	private Date dtTimeLine;
	
	@NotNull
	@Column(name="dsTimeLine", nullable=false, length=1000)
	private String dsTimeLine;
	
	@Column(name="dsResposta", length=1000)
	private String dsResposta;
	
	@Column(name="qtCurti", nullable=false) 
	private Integer qtCurti;
	
	public Integer getQtCurti() {
		return qtCurti;
	}

	public void setQtCurti(Integer qtCurti) {
		this.qtCurti = qtCurti;
	}

	@Column(name="txImagem", length=1000)
	private String txImagem;

	public String getTxImagem() {
		return txImagem;
	}

	public void setTxImagem(String txImagem) {
		this.txImagem = txImagem;
	}

	public Integer getIdTimeLine() {
		return idTimeLine;
	}

	public void setIdTimeLine(Integer idTimeLine) {
		this.idTimeLine = idTimeLine;
	}

	public Long getIdEscola() {
		return idEscola;
	}

	public void setIdEscola(Long idEscola) {
		this.idEscola = idEscola;
	}

	public String getNoFaceBook() {
		return noFaceBook;
	}

	public void setNoFaceBook(String noFaceBook) {
		this.noFaceBook = noFaceBook;
	}

	public String getFotoFaceBook() {
		return fotoFaceBook;
	}

	public void setFotoFaceBook(String fotoFaceBook) {
		this.fotoFaceBook = fotoFaceBook;
	}

	public Integer getTpTimeLine() {
		return tpTimeLine;
	}

	public void setTpTimeLine(Integer tpTileLine) {
		this.tpTimeLine = tpTileLine;
	}

	public Date getDtTimeLine() {
		return dtTimeLine;
	}

	public void setDtTimeLine(Date dtTimeLine) {
		this.dtTimeLine = dtTimeLine;
	}

	public String getDsTimeLine() {
		return dsTimeLine;
	}

	public void setDsTimeLine(String dsTimeLine) {
		this.dsTimeLine = dsTimeLine;
	}

	public String getDsResposta() {
		return dsResposta;
	}

	public void setDsResposta(String dsResposta) {
		this.dsResposta = dsResposta;
	}
	
}