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
public class EmmissionSodeci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmSodeci;
	private String codmvt;
	private String typmvt;
	private String codexp;
	private String idabon;
	private String perfact;
	private String typfact;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datlimit;
	private String sens;
	private int montttc;
	private int montfraisp;
	private int montfraisb;
	private String numfact;
	private String refbranch;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateEnr;
//	@Temporal(TemporalType.TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hhmmss")
	private String heureEnr;
	private String statut="N";
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date dateChargement=new Date();
	public EmmissionSodeci() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EmmissionSodeci(String codmvt, String typmvt, String codexp, String idabon, String perfact, String typfact,
			Date datlimit, String sens, int montttc, int montfraisp, int montfraisb, String numfact, String refbranch) {
		super();
		this.codmvt = codmvt;
		this.typmvt = typmvt;
		this.codexp = codexp;
		this.idabon = idabon;
		this.perfact = perfact;
		this.typfact = typfact;
		this.datlimit = datlimit;
		this.sens = sens;
		this.montttc = montttc;
		this.montfraisp = montfraisp;
		this.montfraisb = montfraisb;
		this.numfact = numfact;
		this.refbranch = refbranch;
		
		
	}


	public EmmissionSodeci(String codmvt, String typmvt, String codexp, String idabon, String perfact,
			String typfact, Date datlimit, String sens, int montttc, int montfraisp, int montfraisb, String numfact,
			String refbranch, Date dateEnr) {
		super();
		this.codmvt = codmvt;
		this.typmvt = typmvt;
		this.codexp = codexp;
		this.idabon = idabon;
		this.perfact = perfact;
		this.typfact = typfact;
		this.datlimit = datlimit;
		this.sens = sens;
		this.montttc = montttc;
		this.montfraisp = montfraisp;
		this.montfraisb = montfraisb;
		this.numfact = numfact;
		this.refbranch = refbranch;
		this.dateEnr = dateEnr;
	}


	public EmmissionSodeci(String codmvt, String typmvt, String codexp, String idabon, String perfact, String typfact,
			Date datlimit, String sens, int montttc, int montfraisp, int montfraisb, String numfact, String refbranch,
			Date dateEnr, String heureEnr) {
		super();
		this.codmvt = codmvt;
		this.typmvt = typmvt;
		this.codexp = codexp;
		this.idabon = idabon;
		this.perfact = perfact;
		this.typfact = typfact;
		this.datlimit = datlimit;
		this.sens = sens;
		this.montttc = montttc;
		this.montfraisp = montfraisp;
		this.montfraisb = montfraisb;
		this.numfact = numfact;
		this.refbranch = refbranch;
		this.dateEnr = dateEnr;
		this.heureEnr = heureEnr;
	}


	public EmmissionSodeci(String codmvt) {
		super();
		this.codmvt = codmvt;
	}


	public long getIdEmSodeci() {
		return idEmSodeci;
	}
	public void setIdEmSodeci(long idEmSodeci) {
		this.idEmSodeci = idEmSodeci;
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
	public Date getDatlimit() {
		return datlimit;
	}
	public void setDatlimit(Date datlimit) {
		this.datlimit = datlimit;
	}
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	public int getMontttc() {
		return montttc;
	}
	public void setMontttc(int montttc) {
		this.montttc = montttc;
	}
	public int getMontfraisp() {
		return montfraisp;
	}
	public void setMontfraisp(int montfraisp) {
		this.montfraisp = montfraisp;
	}
	public int getMontfraisb() {
		return montfraisb;
	}
	public void setMontfraisb(int montfraisb) {
		this.montfraisb = montfraisb;
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
	public String getHeureEnr() {
		return heureEnr;
	}
	public void setHeureEnr(String heureEnr) {
		this.heureEnr = heureEnr;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateChargement() {
		return dateChargement;
	}
	public void setDateChargement(Date dateChargement) {
		this.dateChargement = dateChargement;
	}
	


}
