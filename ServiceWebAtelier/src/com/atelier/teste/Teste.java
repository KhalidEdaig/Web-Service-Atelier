package com.atelier.teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.atelier.entities.Carburant;
import com.atelier.entities.HistCarb;
import com.atelier.entities.Station;
import com.atelier.services.ServiceStation;

public class Teste {
	
	static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ServiceStation");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// The EntityManager class allows operations such as create, read, update, delete
		  EntityManager em = emf.createEntityManager();
		  // Used to issue transactions on the EntityManager 
		  EntityTransaction transaction = null;
		 
		  try {
	           // Get a transaction
	            transaction = em.getTransaction();
	            // Begin the transaction
	            transaction.begin();
	              // Get the station object
	           /* Station station=new Station();
	            station.setStNom("Total");
	            station.setStAddress("Boukhalef Tanger route Rabat");
	            station.setStVillle("Tanger");
	         // insert the station
	            em.persist(station);
	         // Get the carburant object
	            Carburant carburant1=new Carburant();
	            Carburant carburant2=new Carburant();
	         // Change the values
		  		carburant1.setCarbNom("Essence");
		  		carburant1.setCarbDescription("types d’essence : le sans-plomb 95");
		  		carburant2.setCarbNom("Gazole");
		  		carburant2.setCarbDescription(" moteurs diesel.");
		  	   // insert the carburant1
	            em.persist(carburant1);
	         // insert the carburant1
	            em.persist(carburant2);
	            // Commit the transaction
	         // Get the histcarb object
	            HistCarb hc=new HistCarb();
	         // Change the values
	            hc.setDate(new Date());
	            hc.setPrix(30000);
	            hc.setStation(station);
	            hc.setCarburant(em.find(Carburant.class, 1));
	         // insert the hiscarb
	            em.persist(hc);
	            Query query = em.createQuery("SELECT h FROM HistCarb h INNER JOIN h.station s  WHERE s.stid = :id ");
	            query.setParameter("id", 4);
	            List<HistCarb> listHistCarbs=query.getResultList();*/
	            ServiceStation service=new ServiceStation();
	            List<HistCarb> listHistCarbs = service.getPrixJournalierCarb(em.find(Station.class, 7));
			  for(HistCarb s:listHistCarbs) {
				  //System.out.println("prix : "+s);
				
				  System.out.println("| HC Prix : "+s.getPrix()+"| HC Date : "+s.getDate()
				  +" | ID Station : "+s.getStation().toString()
				  +" | ID Carburant : "+s.getCarburant().toString());
				  Query q = em.createQuery("DELETE FROM HistCarb h WHERE h.histcarbid = :id");
				  q.setParameter("id", s.getHistcarbid());
				  q.executeUpdate();
				  
				 
			  }
	            //ServiceStation service=new ServiceStation();
	            //service.deleteStation(4);
	            transaction.commit();
	        } catch (Exception ex) {
	            // If there are any exceptions, roll back the changes
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            // Print the Exception
	            ex.printStackTrace();
	        } finally {
	            // Close the EntityManager
	            em.close();
	        }

	}

}
