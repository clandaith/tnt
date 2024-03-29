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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "warband_character")
public class TntCharacter implements Serializable {
	private static final long serialVersionUID = 6086328523626626619L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "warband_id")
	private Warband warband;

	@ManyToOne
	@JoinColumn(name = "warband_unit_id")
	private WarbandUnit warbandUnit;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "unit_type_id")
	private UnitType unitType;

	@NotNull
	private String name;
	private String background;
	@Min(0)
	@NotNull
	private Integer defense;
	@Min(1)
	@NotNull
	private Integer wounds;
	@Min(0)
	@NotNull
	private Integer move;
	@Min(0)
	@NotNull
	private Integer melee;
	@Min(0)
	@NotNull
	private Integer ranged;
	@Min(0)
	@NotNull
	private Integer strength;
	@Min(0)
	@NotNull
	private Integer mettle;
	@Min(0)
	@NotNull
	@Column(name = "base_cost")
	private Integer baseCost;

	@Min(0)
	@NotNull
	private Integer xp;

	@Min(0)
	@NotNull
	@Column(name = "unused_xp")
	private Integer unusedXP;

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		if (xp == null)
			xp = 0;

		this.xp = xp;
	}

	public Integer getUnusedXP() {
		return unusedXP;
	}

	public void setUnusedXP(Integer unusedXP) {
		if (unusedXP == null)
			unusedXP = 0;
		this.unusedXP = unusedXP;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_skills_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
	private Set<Skill> skills;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_equipment_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
	private Set<Equipment> equipment;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_melee_weapon_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "melee_weapon_id", referencedColumnName = "id"))
	private Set<MeleeWeapon> meleeWeapons;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_ranged_weapon_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ranged_weapon_id", referencedColumnName = "id"))
	private Set<RangedWeapon> rangedWeapons;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_armor_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "armor_id", referencedColumnName = "id"))
	private Set<Armor> armors;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_detriment_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "detriment_id", referencedColumnName = "id"))
	private Set<Detriment> detriments;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_mutation_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "mutation_id", referencedColumnName = "id"))
	private Set<Mutation> mutations;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_general_abilities_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "general_ability_id", referencedColumnName = "id"))
	private Set<GeneralAbility> generalAbilities;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_grenade_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "grenade_id", referencedColumnName = "id"))
	private Set<Grenade> grenades;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "warband_character_injuries_link", joinColumns = @JoinColumn(name = "warband_character_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "injury_id", referencedColumnName = "id"))
	private Set<Injury> injuries;

	public TntCharacter() {
	}

	public TntCharacter(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public TntCharacter(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Warband getWarband() {
		return warband;
	}

	public void setWarband(Warband warband) {
		this.warband = warband;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null)
			name = "Unnammed";
		this.name = name;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getWounds() {
		return wounds;
	}

	public void setWounds(Integer wounds) {
		this.wounds = wounds;
	}

	public Integer getMove() {
		return move;
	}

	public void setMove(Integer move) {
		this.move = move;
	}

	public Integer getMelee() {
		return melee;
	}

	public void setMelee(Integer melee) {
		this.melee = melee;
	}

	public Integer getRanged() {
		return ranged;
	}

	public void setRanged(Integer ranged) {
		this.ranged = ranged;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getMettle() {
		return mettle;
	}

	public void setMettle(Integer mettle) {
		this.mettle = mettle;
	}

	public Integer getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Integer baseCost) {
		if (baseCost == null)
			baseCost = 0;

		this.baseCost = baseCost;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(Set<Equipment> equipment) {
		this.equipment = equipment;
	}

	public Set<MeleeWeapon> getMeleeWeapons() {
		return meleeWeapons;
	}

	public void setMeleeWeapons(Set<MeleeWeapon> meleeWeapons) {
		this.meleeWeapons = meleeWeapons;
	}

	public Set<RangedWeapon> getRangedWeapons() {
		return rangedWeapons;
	}

	public void setRangedWeapons(Set<RangedWeapon> rangedWeapons) {
		this.rangedWeapons = rangedWeapons;
	}

	public Set<Armor> getArmors() {
		return armors;
	}

	public void setArmors(Set<Armor> armors) {
		this.armors = armors;
	}

	public Set<Detriment> getDetriments() {
		return detriments;
	}

	public void setDetriments(Set<Detriment> detriments) {
		this.detriments = detriments;
	}

	public Set<Mutation> getMutations() {
		return mutations;
	}

	public void setMutations(Set<Mutation> mutations) {
		this.mutations = mutations;
	}

	public Set<GeneralAbility> getGeneralAbilities() {
		return generalAbilities;
	}

	public void setGeneralAbilities(Set<GeneralAbility> generalAbilities) {
		this.generalAbilities = generalAbilities;
	}

	public Set<Grenade> getGrenades() {
		return grenades;
	}

	public void setGrenades(Set<Grenade> grenades) {
		this.grenades = grenades;
	}

	@Override
	public String toString() {
		return getId() + " :: " + getName();
	}

	public Set<Injury> getInjuries() {
		return injuries;
	}

	public void setInjuries(Set<Injury> injuries) {
		this.injuries = injuries;
	}

	public WarbandUnit getWarbandUnit() {
		return warbandUnit;
	}

	public void setWarbandUnit(WarbandUnit warbandUnit) {
		this.warbandUnit = warbandUnit;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}
}
