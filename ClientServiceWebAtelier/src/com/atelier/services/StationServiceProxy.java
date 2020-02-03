package com.atelier.services;

public class StationServiceProxy implements com.atelier.services.StationService {
  private String _endpoint = null;
  private com.atelier.services.StationService stationService = null;
  
  public StationServiceProxy() {
    _initStationServiceProxy();
  }
  
  public StationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initStationServiceProxy();
  }
  
  private void _initStationServiceProxy() {
    try {
      stationService = (new com.atelier.services.ServiceStationServiceLocator()).getStationServicePort();
      if (stationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stationService != null)
      ((javax.xml.rpc.Stub)stationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.atelier.services.StationService getStationService() {
    if (stationService == null)
      _initStationServiceProxy();
    return stationService;
  }
  
  public void createStation(java.lang.String stNom, java.lang.String stVille, java.lang.String stAddress) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.createStation(stNom, stVille, stAddress);
  }
  
  public com.atelier.services.Carburant[] readAllCarburants() throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.readAllCarburants();
  }
  
  public com.atelier.services.HistCarb[] getPrixJournalierCarb(com.atelier.services.Station arg0) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.getPrixJournalierCarb(arg0);
  }
  
  public void upateCarburant(int id, java.lang.String carbNom, java.lang.String carbDesc) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.upateCarburant(id, carbNom, carbDesc);
  }
  
  public com.atelier.services.Station getStation(int id) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.getStation(id);
  }
  
  public com.atelier.services.Carburant getCarburant(int id) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.getCarburant(id);
  }
  
  public com.atelier.services.Station[] readAllStations() throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.readAllStations();
  }
  
  public void upateStation(int id, java.lang.String stNom, java.lang.String stVille, java.lang.String stAddress) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.upateStation(id, stNom, stVille, stAddress);
  }
  
  public void deleteCarburant(int id) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.deleteCarburant(id);
  }
  
  public com.atelier.services.HistCarb[] readAllHutCarbs() throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    return stationService.readAllHutCarbs();
  }
  
  public void createCarburant(java.lang.String carbNom, java.lang.String carbDesc) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.createCarburant(carbNom, carbDesc);
  }
  
  public void deleteStation(int id) throws java.rmi.RemoteException{
    if (stationService == null)
      _initStationServiceProxy();
    stationService.deleteStation(id);
  }
  
  
}