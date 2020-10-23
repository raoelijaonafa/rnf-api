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
@Table(name="LOI_FINANCE")
public class LoiFinanceEntity  {

	@Id	
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="LOI_FINANCE_ID_LF", nullable=false)
	private Integer idLF;
	
	@Column(name="LF")
	private String lf;
	 
	 
		@Cascade({CascadeType.REMOVE})
		@OneToMany(mappedBy = "loi", fetch = FetchType.LAZY)
		private List<ExerciceEntity> exercice;


		public Integer getIdLF() {
			return idLF;
		}


		public void setIdLF(Integer idLF) {
			this.idLF = idLF;
		}


		public String getLf() {
			return lf;
		}


		public void setLf(String lf) {
			this.lf = lf;
		}


		public List<ExerciceEntity> getExercice() {
			return exercice;
		}


		public void setExercice(List<ExerciceEntity> exercice) {
			this.exercice = exercice;
		}
	
	
}
