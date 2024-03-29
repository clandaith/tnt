package com.dev801.tnt.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mutations_view")
public class Mutation implements Serializable {
	private static final long serialVersionUID = -665209848507686624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Integer cost;

	private String description;

	@Column(name = "mutation_type_id")
	private Integer mutationTypeId;

	@Column(name = "mutation_type_name")
	private String mutationTypeName;

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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMutationTypeId() {
		return mutationTypeId;
	}

	public void setMutationTypeId(Integer mutationTypeId) {
		this.mutationTypeId = mutationTypeId;
	}

	public String getMutationTypeName() {
		return mutationTypeName;
	}

	public void setMutationTypeName(String mutationTypeName) {
		this.mutationTypeName = mutationTypeName;
	}

}
