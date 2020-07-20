package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unit_type")
public class UnitType implements Serializable {
	private static final long serialVersionUID = -2740710179359297192L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "unitType")
	private Set<TntCharacter> tntCharacters;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TntCharacter> getTntCharacters() {
		return tntCharacters;
	}

	public void setTntCharacters(Set<TntCharacter> tntCharacters) {
		this.tntCharacters = tntCharacters;
	}

}
