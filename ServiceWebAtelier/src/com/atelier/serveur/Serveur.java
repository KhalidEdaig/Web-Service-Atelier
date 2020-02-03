package com.atelier.serveur;

import javax.xml.ws.Endpoint;

import com.atelier.services.ServiceStation;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://localhost:9000/";
		Endpoint.publish(url, new ServiceStation());
		System.out.println(url);


	}

}
