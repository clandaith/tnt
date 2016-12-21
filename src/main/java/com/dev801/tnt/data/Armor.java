package com.dev801.tnt.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "armors_view")
public class Armor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;

	@Column(name = "melee_bonus")
	private Integer meleeBonus;

	@Column(name = "ranged_bonus")
	private Integer rangedBonus;

	@Column(name = "cost_by_wound_1")
	private Integer costByWound1;

	@Column(name = "cost_by_wound_2")
	private Integer costByWound2;

	@Column(name = "cost_by_wound_3")
	private Integer costByWound3;

	@Column(name = "rarity_id")
	private Integer rarityId;

	@Column(name = "rarity_level_name")
	private String rarityLevelName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "armor_special_rules_link", joinColumns = @JoinColumn(name = "armor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "special_rule_id", referencedColumnName = "id"))
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

	public Integer getMeleeBonus() {
		return meleeBonus;
	}

	public void setMeleeBonus(Integer meleeBonus) {
		this.meleeBonus = meleeBonus;
	}

	public Integer getRangedBonus() {
		return rangedBonus;
	}

	public void setRangedBonus(Integer rangedBonus) {
		this.rangedBonus = rangedBonus;
	}

	public Integer getCostByWound1() {
		return costByWound1;
	}

	public void setCostByWound1(Integer costByWound1) {
		this.costByWound1 = costByWound1;
	}

	public Integer getCostByWound2() {
		return costByWound2;
	}

	public void setCostByWound2(Integer costByWound2) {
		this.costByWound2 = costByWound2;
	}

	public Integer getCostByWound3() {
		return costByWound3;
	}

	public void setCostByWound3(Integer costByWound3) {
		this.costByWound3 = costByWound3;
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

}
