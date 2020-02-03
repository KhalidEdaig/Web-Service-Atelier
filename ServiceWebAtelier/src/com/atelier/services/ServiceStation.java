package com.atelier.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.atelier.entities.Carburant;
import com.atelier.entities.HistCarb;
import com.atelier.entities.Station;

@WebService(name = "StationService")
public class ServiceStation {
	private final EntityManagerFactory emf=Persistence.createEntityManagerFactory("ServiceStation");
	
	/*************************************************************CRUB Station ***********************************************/
	/**
     * Create a new Station.
     * 
     * @param stNom
     * @param stVille
     * @param stAddress
     */
	@WebMethod
    public  void createStation(
    		@WebParam(name = "stNom")String stNom
    		,@WebParam(name = "stVille")String stVille
    		,@WebParam(name = "stAddress")String stAddress) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Create a new Station object
            Station station = new Station();
            station.setStNom(stNom);
            station.setStVillle(stVille);
            station.setStAddress(stAddress);
            // Save the station object
            em.persist(station);
            // Commit the transaction
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
    /**
     * Read all the Station.
     * 
     * @return a List of Station
     */
	@WebMethod
    public  List<Station> readAllStations() {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            List<Station> list=em.createQuery("SELECT st FROM Station st",
                    Station.class).getResultList(); 
            // Commit the transaction
            List<Station> listSt=new ArrayList<Station>();
            for(Station s:list) {
            	Station st=new Station(s.getStid(), s.getStNom(), s.getStVillle(), s.getStAddress());
            	listSt.add(st);
            }
            transaction.commit();
            // Get a List of station and return
            return  listSt;    
        } catch (Exception ex) {
             //If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            em.close();
        }
        return null;
    }
	/**
     * Read one the Station by id.
     * @return one of Stations
     */
	@WebMethod
	public Station getStation(
			@WebParam(name = "id")int id) {
		// The EntityManager class allows operations such as create, read, update, delete
		  EntityManager em = emf.createEntityManager();
		  // Used to issue transactions on the EntityManager 
		  EntityTransaction transaction = null;
		//create Object Station
		  //Station station=new Station();
		  try {
		  	// Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Commit the transaction
            transaction.commit();
            Station s=em.find(Station.class, id); 
            return new Station(s.getStid(),s.getStNom(),s.getStVillle(),s.getStAddress());       
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
		//Return Object Station
		  return null;
	}
	 /**
     * Delete the existing Station.
     * 
     * @param id
     */
	@WebMethod
    public void deleteStation(@WebParam(name = "id") int id) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Get the all id the HistoriqueCarbration reference th Station object
			/**
			 * return all the HistoriqueCarburant by previosly selected station object with id
			 * SELECT h FROM HistCarb h JOIN h.station s  WHERE s.stid = :id
			 */
            Query query = em.createQuery("SELECT h FROM HistCarb h JOIN h.station s  WHERE s.stid = :id");
            query.setParameter("id",id);
            List<HistCarb> listHistCarbs=query.getResultList();
		    for(HistCarb s:listHistCarbs) {
		    	Query q = em.createQuery("DELETE FROM HistCarb h WHERE h.histcarbid = :id");
				q.setParameter("id", s.getHistcarbid());
				q.executeUpdate();
		    } 
		    Query qst = em.createQuery("DELETE FROM Station s WHERE s.stid = :id");
			qst.setParameter("id", id);
			qst.executeUpdate();
            // Commit the transaction
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
	
	/**
     * Update the existing Station.
     * 
     * @param id
     * @param stNom
     * @param stVille
     * @param stAddress
     */
	@WebMethod
    public void upateStation(@WebParam(name = "id")int id,
    		@WebParam(name = "stNom")String stNom
    		,@WebParam(name = "stVille")String stVille
    		,@WebParam(name = "stAddress")String stAddress) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Get the Student object
            Station station =em.find(Station.class, id);
            // Change the values
            station.setStNom(stNom);
            station.setStVillle(stVille);
            station.setStAddress(stAddress);
            // Update the student
            em.persist(station);
            // Commit the transaction
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
	/*************************************************************CRUB Carburant ***********************************************/
	/**
     * Create a new Carburant.
     * 
     * @param carbNom
     * @param carbDescription
     * 
     */
	@WebMethod
    public  void createCarburant(
    		@WebParam(name = "carbNom")String carbNom
    		,@WebParam(name = "carbDesc")String carbDesc) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Create a new Carburant object
            Carburant carburant = new Carburant();
            carburant.setCarbNom(carbNom);
            carburant.setCarbDescription(carbDesc);
            // Save the Carburant object
            em.persist(carburant);
            // Commit the transaction
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
    /**
     * Read all the Carburant.
     * 
     * @return a List of Carburant
     */
	@WebMethod
    public  List<Carburant> readAllCarburants() {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
           // Get a List of Carburant and return list
         // Commit the transaction
           List<Carburant> list = em.createQuery("SELECT carb FROM Carburant carb",
            		Carburant.class).getResultList();
            List<Carburant> listcarb=new ArrayList<Carburant>();
            
            for(Carburant c:list) {
            	Carburant carb=new Carburant(c.getCarbid(), c.getCarbNom(), c.getCarbDescription());
            	listcarb.add(carb);
            }
            // Commit the transaction
            transaction.commit();
            // Get a List of station and return
            return  listcarb;    
           
        } catch (Exception ex) {
             //If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            em.close();
        }
        return null;
    }
	/**
     * Read one the Carburant by id.
     * @return one of Carburant
     */
	@WebMethod
	public Carburant getCarburant(@WebParam(name = "id")int id) {
		// The EntityManager class allows operations such as create, read, update, delete
		  EntityManager em = emf.createEntityManager();
		  // Used to issue transactions on the EntityManager 
		  EntityTransaction transaction = null;
		  try {
		  	// Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            
            //Return Object Station
            Carburant c=em.find(Carburant.class, id);
         // Commit the transaction
            transaction.commit();
           return new Carburant(c.getCarbid(), c.getCarbNom(), c.getCarbDescription());
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
		return null;
	}
	 /**
     * Delete the existing Carburant.
     * 
     * @param id
     */
	@WebMethod
    public void deleteCarburant(@WebParam(name = "id") int id) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Get the all id the HistoriqueCarbration reference th Carburant object
			/**
			 * return all the HistoriqueCarburant by previosly selected Carburant object with id
			 * SELECT h FROM HistCarb h JOIN h.carburant carb  WHERE carb.carbid = :id
			 */
            Query query = em.createQuery("SELECT h FROM HistCarb h JOIN h.carburant carb  WHERE carb.carbid = :id");
            query.setParameter("id",id);
            List<HistCarb> listHistCarbs=query.getResultList();
		    for(HistCarb s:listHistCarbs) {
		    	Query q = em.createQuery("DELETE FROM HistCarb h WHERE h.histcarbid = :id");
				q.setParameter("id", s.getHistcarbid());
				q.executeUpdate();
		    }
		    //Delete Carburant
		    Query qcarb = em.createQuery("DELETE FROM Carburant c WHERE c.carbid= :id");
			qcarb.setParameter("id", id);
			qcarb.executeUpdate();
            // Commit the transaction
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
	
	/**
     * Update the existing Station.
     * 
     * @param carbid
     * @param carbNom
     * @param carbDesc
     */
	@WebMethod
    public void upateCarburant(@WebParam(name = "id")int id,
    		@WebParam(name = "carbNom")String carbNom
    		,@WebParam(name = "carbDesc")String carbDesc) {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Get the Carburant object
            Carburant carburant = em.find(Carburant.class, id);
            // Change the values
            carburant.setCarbNom(carbNom);
            carburant.setCarbDescription(carbDesc);
            // Update the carburant
            em.persist(carburant);
            // Commit the transaction
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
	/************************************************* Gestion de prix d'une station  *************************************************/
	
	public List<HistCarb> getPrixJournalierCarb(Station station){
		  // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
            List<HistCarb> list=em.createQuery("SELECT h FROM HistCarb h INNER JOIN h.station s  WHERE s.stid = :id ").setParameter("id", station.getStid()).getResultList();
            List<HistCarb> listCarb=new ArrayList<HistCarb>();
            for(HistCarb hc:list) {
            	HistCarb h=new HistCarb(getStation(hc.getStation().getStid()),getCarburant(hc.getCarburant().getCarbid()),hc.getPrix(),hc.getDate());
            	listCarb.add(h);
            }
            // Commit the transaction
            transaction.commit();
            //Retrun result
            return listCarb;
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
		
		return null;
		
	}
	@WebMethod
    public  List<HistCarb> readAllHutCarbs() {
        // Create an EntityManager
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = em.getTransaction();
            // Begin the transaction
            transaction.begin();
           // Get a List of HistCarb and return list
         // Commit the transaction
           List<HistCarb> list = em.createQuery("SELECT histcarb FROM HistCarb histcarb",
        		   HistCarb.class).getResultList();
            List<HistCarb> listhistcarb=new ArrayList<HistCarb>();
            
            for(HistCarb hc:list) {
            	HistCarb h=new HistCarb(getStation(hc.getStation().getStid()),getCarburant(hc.getCarburant().getCarbid()),hc.getPrix(),hc.getDate());
            	listhistcarb.add(h);
            }
            // Commit the transaction
            transaction.commit();
            // Get a List of HistCarb and return
            return  listhistcarb;    
           
        } catch (Exception ex) {
             //If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            em.close();
        }
        return null;
    }

	
}//Fin la class





















