package com.atelier.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name = "carburants")
@XmlRootElement(name="carburant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Carburant implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carburant",nullable = false)
	private int carbid;
	@Column(name = "nom_carburant")
	private String carbNom;
	@Column(name = "description_carburant")
	private String carbDescription;
	@OneToMany(mappedBy = "station")
	@XmlTransient
	private List<HistCarb> histcarb =new ArrayList<HistCarb>();
	public Carburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Carburant(int carbid, String carbNom, String carbDescription) {
		super();
		this.carbid = carbid;
		this.carbNom = carbNom;
		this.carbDescription = carbDescription;
	}

	public Carburant(String carbNom, String carbDescription) {
		super();
		this.carbNom = carbNom;
		this.carbDescription = carbDescription;
	}
	public int getCarbid() {
		return carbid;
	}
	public void setCarbid(int carbid) {
		this.carbid = carbid;
	}
	public String getCarbNom() {
		return carbNom;
	}
	public void setCarbNom(String carbNom) {
		this.carbNom = carbNom;
	}
	public String getCarbDescription() {
		return carbDescription;
	}
	public void setCarbDescription(String carbDescription) {
		this.carbDescription = carbDescription;
	}
	public List<HistCarb> getHistcarb() {
		return histcarb;
	}
	public void setHistcarb(List<HistCarb> histcarb) {
		this.histcarb = histcarb;
	}

	@Override
	public String toString() {
		return "Carburant [carbid=" + carbid + ", carbNom=" + carbNom + ", carbDescription=" + carbDescription + "]";
	}

	

}
