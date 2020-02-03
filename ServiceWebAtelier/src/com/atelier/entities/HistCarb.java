package com.atelier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "historiqueCarburants")
@XmlRootElement(name = "historiqueCarburant")
public class HistCarb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int histcarbid;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stid")
	private Station station;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carbid")
	private Carburant carburant;
	// additional fields
	private double prix;
	@Column(name = "date_Enregistrement")
    @Temporal(TemporalType.DATE)
	private Date date;
	public HistCarb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistCarb(Station station, Carburant carburant, double prix, Date date) {
		super();
		this.station = station;
		this.carburant = carburant;
		this.prix = prix;
		this.date = date;
	}
	public HistCarb(double prix, Date date) {
		super();
		this.prix = prix;
		this.date = date;
	}
	public int getHistcarbid() {
		return histcarbid;
	}
	public void setHistcarbid(int histcarbid) {
		this.histcarbid = histcarbid;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Carburant getCarburant() {
		return carburant;
	}
	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "HistCarb [histcarbid=" + histcarbid + ", station=" + station + ", carburant=" + carburant + ", prix="
				+ prix + ", date=" + date + "]";
	}
	
	
	

}
