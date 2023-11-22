package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
