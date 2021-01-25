package br.edu.ifsp.arq.projeto.appwebparoquia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="missa")
public class Missa {
	
	@Id
	@Column(name="dia")
	private String diaSemana;
	
	@NotNull
	private String horário;
		
	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorário() {
		return horário;
	}

	public void setHorário(String horário) {
		this.horário = horário;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Missa other = (Missa) obj;
		if (diaSemana != other.diaSemana)
			return false;
		return true;
	}
}
