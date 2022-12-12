package com.efacture.dev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ReglementCie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRgCie;
	private String codmvt;
	private String typmvt;
	private String codexp;
	private String idabon;
	private String perfact;
	private String typfact;
	private String sens;
	private String numfact;
	private String refbranch;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateEnr = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heureEnr = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateRegle = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private Date heureRegle = new Date(System.currentTimeMillis());
	private int montantRegle;
	private String numeroRecu;
	private String typeCanal;
	private String idabon2;
	private String statut;

	public ReglementCie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReglementCie(long idRgCie, String codmvt, String typmvt, String codexp, String idabon, String perfact,
			String typfact, String sens, String numfact, String refbranch, Date dateEnr, Date heureEnr,
			Date dateRegle, Date heureRegle, int montantRegle, String numeroRecu, String typeCanal, String idabon2,
			String statut) {
		super();
		this.idRgCie = idRgCie;
		this.codmvt = codmvt;
		this.typmvt = typmvt;
		this.codexp = codexp;
		this.idabon = idabon;
		this.perfact = perfact;
		this.typfact = typfact;
		this.sens = sens;
		this.numfact = numfact;
		this.refbranch = refbranch;
		this.dateEnr = dateEnr;
		this.heureEnr = heureEnr;
		this.dateRegle = dateRegle;
		this.heureRegle = heureRegle;
		this.montantRegle = montantRegle;
		this.numeroRecu = numeroRecu;
		this.typeCanal = typeCanal;
		this.idabon2 = idabon2;
		this.statut = statut;
	}

	public long getIdRgCie() {
		return idRgCie;
	}

	public void setIdRgCie(long idRgCie) {
		this.idRgCie = idRgCie;
	}

	public String getCodmvt() {
		return codmvt;
	}

	public void setCodmvt(String codmvt) {
		this.codmvt = codmvt;
	}

	public String getTypmvt() {
		return typmvt;
	}

	public void setTypmvt(String typmvt) {
		this.typmvt = typmvt;
	}

	public String getCodexp() {
		return codexp;
	}

	public void setCodexp(String codexp) {
		this.codexp = codexp;
	}

	public String getIdabon() {
		return idabon;
	}

	public void setIdabon(String idabon) {
		this.idabon = idabon;
	}

	public String getPerfact() {
		return perfact;
	}

	public void setPerfact(String perfact) {
		this.perfact = perfact;
	}

	public String getTypfact() {
		return typfact;
	}

	public void setTypfact(String typfact) {
		this.typfact = typfact;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public String getNumfact() {
		return numfact;
	}

	public void setNumfact(String numfact) {
		this.numfact = numfact;
	}

	public String getRefbranch() {
		return refbranch;
	}

	public void setRefbranch(String refbranch) {
		this.refbranch = refbranch;
	}

	public Date getDateEnr() {
		return dateEnr;
	}

	public void setDateEnr(Date dateEnr) {
		this.dateEnr = dateEnr;
	}

	public Date getHeureEnr() {
		return heureEnr;
	}

	public void setHeureEnr(Date heureEnr) {
		this.heureEnr = heureEnr;
	}

	public Date getDateRegle() {
		return dateRegle;
	}

	public void setDateRegle(Date dateRegle) {
		this.dateRegle = dateRegle;
	}

	public Date getHeureRegle() {
		return heureRegle;
	}

	public void setHeureRegle(Date heureRegle) {
		this.heureRegle = heureRegle;
	}

	public int getMontantRegle() {
		return montantRegle;
	}

	public void setMontantRegle(int montantRegle) {
		this.montantRegle = montantRegle;
	}

	public String getNumeroRecu() {
		return numeroRecu;
	}

	public void setNumeroRecu(String numeroRecu) {
		this.numeroRecu = numeroRecu;
	}

	public String getTypeCanal() {
		return typeCanal;
	}

	public void setTypeCanal(String typeCanal) {
		this.typeCanal = typeCanal;
	}

	public String getIdabon2() {
		return idabon2;
	}

	public void setIdabon2(String idabon2) {
		this.idabon2 = idabon2;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "ReglementCie [idRgCie=" + idRgCie + ", codmvt=" + codmvt + ", typmvt=" + typmvt + ", codexp=" + codexp
				+ ", idabon=" + idabon + ", perfact=" + perfact + ", typfact=" + typfact + ", sens=" + sens
				+ ", numfact=" + numfact + ", refbranch=" + refbranch + ", dateEnr=" + dateEnr + ", heureEnr="
				+ heureEnr + ", dateRegle=" + dateRegle + ", heureRegle=" + heureRegle + ", montantRegle="
				+ montantRegle + ", numeroRecu=" + numeroRecu + ", typeCanal=" + typeCanal + ", idabon2=" + idabon2
				+ ", statut=" + statut + "]";
	}

}
