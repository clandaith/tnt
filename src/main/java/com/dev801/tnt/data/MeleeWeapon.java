package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "melee_weapons_view")
public class MeleeWeapon implements Serializable {
	private static final long serialVersionUID = -2883771832010638897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;

	@Column(name = "melee_range")
	private Integer meleeRange;

	@Column(name = "thrown_range")
	private Integer thrownRange;

	private Integer strength;
	private Integer reliability;

	@Column(name = "one_handed")
	private Boolean oneHanded;

	private Integer cost;

	@Column(name = "rarity_id")
	private Integer rarityId;

	@Column(name = "rarity_level_name")
	private String rarityLevelName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "melee_weapons_special_rules_link", joinColumns = @JoinColumn(name = "melee_weapon_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "special_rule_id", referencedColumnName = "id"))
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

	public Integer getMeleeRange() {
		return meleeRange;
	}

	public void setMeleeRange(Integer meleeRange) {
		this.meleeRange = meleeRange;
	}

	public Integer getThrownRange() {
		return thrownRange;
	}

	public void setThrownRange(Integer thrownRange) {
		this.thrownRange = thrownRange;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Boolean getOneHanded() {
		return oneHanded;
	}

	public void setOneHanded(Boolean oneHanded) {
		this.oneHanded = oneHanded;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
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

	public Set<SpecialRule> getSpecialRules() {
		return specialRules;
	}

	public void setSpecialRules(Set<SpecialRule> specialRules) {
		this.specialRules = specialRules;
	}

	public Integer getReliability() {
		return reliability;
	}

	public void setReliability(Integer reliability) {
		this.reliability = reliability;
	}

}
