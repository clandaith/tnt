package com.dev801.tnt.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detriments_view")
public class Detriment implements Serializable {
	private static final long serialVersionUID = -4481029741710275506L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String description;

	@Column(name = "detriment_type_id")
	private Integer detrimentTypeId;

	@Column(name = "detriment_type_name")
	private String detrimenTypeName;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDetrimentTypeId() {
		return detrimentTypeId;
	}

	public void setDetrimentTypeId(Integer detrimentTypeId) {
		this.detrimentTypeId = detrimentTypeId;
	}

	public String getDetrimenTypeName() {
		return detrimenTypeName;
	}

	public void setDetrimenTypeName(String detrimenTypeName) {
		this.detrimenTypeName = detrimenTypeName;
	}
}
