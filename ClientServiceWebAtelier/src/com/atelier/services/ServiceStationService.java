/**
 * ServiceStationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atelier.services;

public interface ServiceStationService extends javax.xml.rpc.Service {
    public java.lang.String getStationServicePortAddress();

    public com.atelier.services.StationService getStationServicePort() throws javax.xml.rpc.ServiceException;

    public com.atelier.services.StationService getStationServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
