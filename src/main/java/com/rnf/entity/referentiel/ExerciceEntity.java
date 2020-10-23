package com.rnf.entity.referentiel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EXERCICE")
public class ExerciceEntity  {

	@Id	
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="exercice_id_exercice", nullable=false)
	private Integer idExercice;
	
	@Column(name="exercice")
	private String exercice;
	
	 
	@Cascade({CascadeType.REMOVE})
	@OneToMany(mappedBy = "exercice", fetch = FetchType.LAZY)
	private List<MinistereEntity> ministeres;


	@Column(name="LOI_FINANCE_ID_LF", nullable=true)
	private Integer idLF;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOI_FINANCE_ID_LF", insertable = false, updatable = false)
	private LoiFinanceEntity loi;
	
	
	public Integer getIdExercice() {
		return idExercice;
	}


	public void setIdExercice(Integer idExercice) {
		this.idExercice = idExercice;
	}


	public String getExercice() {
		return exercice;
	}


	public void setExercice(String exercice) {
		this.exercice = exercice;
	}


	public List<MinistereEntity> getMinisteres() {
		return ministeres;
	}


	public void setMinisteres(List<MinistereEntity> ministeres) {
		this.ministeres = ministeres;
	}


	public Integer getIdLF() {
		return idLF;
	}


	public void setIdLF(Integer idLF) {
		this.idLF = idLF;
	}


	public LoiFinanceEntity getLoi() {
		return loi;
	}


	public void setLoi(LoiFinanceEntity loi) {
		this.loi = loi;
	}
	
	
	
	
	
}
