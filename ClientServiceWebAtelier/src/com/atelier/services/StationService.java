/**
 * StationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atelier.services;

public interface StationService extends java.rmi.Remote {
    public void createStation(java.lang.String stNom, java.lang.String stVille, java.lang.String stAddress) throws java.rmi.RemoteException;
    public com.atelier.services.Carburant[] readAllCarburants() throws java.rmi.RemoteException;
    public com.atelier.services.HistCarb[] getPrixJournalierCarb(com.atelier.services.Station arg0) throws java.rmi.RemoteException;
    public void upateCarburant(int id, java.lang.String carbNom, java.lang.String carbDesc) throws java.rmi.RemoteException;
    public com.atelier.services.Station getStation(int id) throws java.rmi.RemoteException;
    public com.atelier.services.Carburant getCarburant(int id) throws java.rmi.RemoteException;
    public com.atelier.services.Station[] readAllStations() throws java.rmi.RemoteException;
    public void upateStation(int id, java.lang.String stNom, java.lang.String stVille, java.lang.String stAddress) throws java.rmi.RemoteException;
    public void deleteCarburant(int id) throws java.rmi.RemoteException;
    public com.atelier.services.HistCarb[] readAllHutCarbs() throws java.rmi.RemoteException;
    public void createCarburant(java.lang.String carbNom, java.lang.String carbDesc) throws java.rmi.RemoteException;
    public void deleteStation(int id) throws java.rmi.RemoteException;
}
