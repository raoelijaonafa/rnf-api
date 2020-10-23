package com.rnf.entity.referentiel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SECTEUR")
public class SecteurEntity  {

	@Id	
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="secteur_id_secteur", nullable=false)
	private Integer idSecteur;
	
	@Column(name="secteur_name")
	private String secteurName;
	
	@Column(name="secteur_abreviation")
	private String secteurabreviation;
	 
	@Cascade({CascadeType.REMOVE})
	@OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
	private List<MinistereEntity> ministeres;

	public Integer getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(Integer idSecteur) {
		this.idSecteur = idSecteur;
	}

	public String getSecteurName() {
		return secteurName;
	}

	public void setSecteurName(String secteurName) {
		this.secteurName = secteurName;
	}

	public String getSecteurabreviation() {
		return secteurabreviation;
	}

	public void setSecteurabreviation(String secteurabreviation) {
		this.secteurabreviation = secteurabreviation;
	}

	public List<MinistereEntity> getMinisteres() {
		return ministeres;
	}

	public void setMinisteres(List<MinistereEntity> ministeres) {
		this.ministeres = ministeres;
	}
	
	
}
