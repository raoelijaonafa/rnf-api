package com.rnf.entity.referentiel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ministere")
public class MinistereEntity {
	
	
	@Id
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="ministere_id_ministere")
	private Integer idMinistere;
		
	@Column(name = "ministere_code", nullable =true)
	private String code;	

	@Column(name = "ministere_libelle", nullable =true)
	private String libelle;
	
	@Column(name = "ministere_abreviation", nullable =true)
	private String abreviation;
	
	@Column(name = "ministere_status", nullable =true)
	private Integer status;
	
	@Column(name="exercice_id_exercice", nullable=true)
	private Integer idExercice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exercice_id_exercice", insertable = false, updatable = false)
	private ExerciceEntity exercice;
	
	
	@Column(name="ministere_id_secteur", nullable=true)
	private Integer idSecteur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ministere_id_secteur", insertable = false, updatable = false)
	private SecteurEntity secteur;
	 

	public Integer getIdMinistere() {
		return idMinistere;
	}

	public void setIdMinistere(Integer idMinistere) {
		this.idMinistere = idMinistere;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(Integer idSecteur) {
		this.idSecteur = idSecteur;
	}

	public SecteurEntity getSecteur() {
		return secteur;
	}

	public void setSecteur(SecteurEntity secteur) {
		this.secteur = secteur;
	}

	public Integer getIdExercice() {
		return idExercice;
	}

	public void setIdExercice(Integer idExercice) {
		this.idExercice = idExercice;
	}

	public ExerciceEntity getExercice() {
		return exercice;
	}

	public void setExercice(ExerciceEntity exercice) {
		this.exercice = exercice;
	}
 	
 
	 
	  
	
}
