package com.atelier.web;

import java.util.List;

import com.atelier.services.Station;
import com.atelier.services.StationServiceProxy;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StationServiceProxy stub=new StationServiceProxy();
		try {
			Station[] listStation=stub.readAllStations();	
			for(int i=0; i<listStation.length ; i++) {
				System.out.println("ID : "+listStation[i].getStid());
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
