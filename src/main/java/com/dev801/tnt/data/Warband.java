package com.dev801.tnt.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "warband")
public class Warband implements Serializable {

	private static final long serialVersionUID = 6874804266819231623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "warband_name")
	private String warbandName;

	private String background;

	@ManyToOne
	@JoinColumn(name = "warband_type_id")
	private WarbandType warbandTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;

	@NotNull
	@Column(name = "user_id")
	private Integer userId;

	private String notes;

	@NotNull
	@OneToMany(mappedBy = "warband")
	private List<TntCharacter> tntCharacters = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWarbandName() {
		return warbandName;
	}

	public void setWarbandName(String warbandName) {
		this.warbandName = warbandName;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<TntCharacter> getTntCharacters() {
		return tntCharacters;
	}

	public void setTntCharacters(List<TntCharacter> tntCharacters) {
		this.tntCharacters = tntCharacters;
	}

	public void addTntCharacter(TntCharacter tntCharacter) {
		if (this.tntCharacters == null) {
			this.tntCharacters = new ArrayList<TntCharacter>();
		}

		this.tntCharacters.add(tntCharacter);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("\nWarband ID: '" + getId() + "' :: " + getWarbandName() + "\n");

		for (TntCharacter tntCharacter : tntCharacters) {
			s.append(tntCharacter.toString() + "\n");
		}

		return s.toString();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public WarbandType getWarbandTypeId() {
		return warbandTypeId;
	}

	public void setWarbandTypeId(WarbandType warbandTypeId) {
		this.warbandTypeId = warbandTypeId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
