package com.ericsson.oss.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Df_kh_Seuil implements Serializable {

	@Id
	@GeneratedValue
	private Long idDfSeuil;
	@NotNull
	private Float dfSeuilMinorPb;
	@NotNull
	private Float dfSeuilMajorPb;
	@NotNull
	private Float dfSeuilCriticalPb;
	public Long getIdDfSeuil() {
		return idDfSeuil;
	}
	public void setIdDfSeuil(Long idDfSeuil) {
		this.idDfSeuil = idDfSeuil;
	}
	public Float getDfSeuilMinorPb() {
		return dfSeuilMinorPb;
	}
	public void setDfSeuilMinorPb(Float dfSeuilMinorPb) {
		this.dfSeuilMinorPb = dfSeuilMinorPb;
	}
	public Float getDfSeuilMajorPb() {
		return dfSeuilMajorPb;
	}
	public void setDfSeuilMajorPb(Float dfSeuilMajorPb) {
		this.dfSeuilMajorPb = dfSeuilMajorPb;
	}
	public Float getDfSeuilCriticalPb() {
		return dfSeuilCriticalPb;
	}
	public void setDfSeuilCriticalPb(Float dfSeuilCriticalPb) {
		this.dfSeuilCriticalPb = dfSeuilCriticalPb;
	}
	
	
}
