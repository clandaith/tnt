package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "grenades_view")
public class Grenade implements Serializable {
	private static final long serialVersionUID = -5170350963423970319L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;
	private Integer strength;
	private Integer cost;
	private Integer rarityId;
	private String rarityLevelName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "grenades_special_rules_link", joinColumns = @JoinColumn(name = "grenade_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "special_rule_id", referencedColumnName = "id"))
	private Set<SpecialRule> specialRules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Set<SpecialRule> getSpecialRules() {
		return specialRules;
	}

	public void setSpecialRules(Set<SpecialRule> specialRules) {
		this.specialRules = specialRules;
	}

	public Integer getRarityId() {
		return rarityId;
	}

	public void setRarityId(Integer rarityId) {
		this.rarityId = rarityId;
	}

	public String getRarityLevelName() {
		return rarityLevelName;
	}

	public void setRarityLevelName(String rarityLevelName) {
		this.rarityLevelName = rarityLevelName;
	}
}
