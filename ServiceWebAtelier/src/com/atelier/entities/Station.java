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
@Table(name = "stations")
@XmlRootElement(name = "station")
@XmlAccessorType(XmlAccessType.FIELD)
public class Station implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_station")
	private int stid;
	@Column(name = "nom_station")
	private String stNom;
	@Column(name = "ville_station")
	private String stVillle;
	@Column(name = "address_station")
	private String stAddress;
	@OneToMany(mappedBy = "carburant")
	@XmlTransient
	private List<HistCarb> histcarb =new ArrayList<HistCarb>();
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station(String stNom, String stVillle, String stAddress) {
		super();
		this.stNom = stNom;
		this.stVillle = stVillle;
		this.stAddress = stAddress;
	}
	
	public Station(int stid, String stNom, String stVillle, String stAddress) {
		super();
		this.stid = stid;
		this.stNom = stNom;
		this.stVillle = stVillle;
		this.stAddress = stAddress;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStNom() {
		return stNom;
	}
	public void setStNom(String stNom) {
		this.stNom = stNom;
	}
	public String getStVillle() {
		return stVillle;
	}
	public void setStVillle(String stVillle) {
		this.stVillle = stVillle;
	}
	public String getStAddress() {
		return stAddress;
	}
	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}
	public List<HistCarb> getHistcarb() {
		return histcarb;
	}
	public void setHistcarb(List<HistCarb> histcarb) {
		this.histcarb = histcarb;
	}
	@Override
	public String toString() {
		return "Station [stid=" + stid + ", stNom=" + stNom + ", stVillle=" + stVillle + ", stAddress=" + stAddress
				+ "]";
	}

	
	

}
