/**
 * HistCarb.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atelier.services;

public class HistCarb  implements java.io.Serializable {
    private com.atelier.services.Carburant carburant;

    private java.util.Calendar date;

    private int histcarbid;

    private double prix;

    private com.atelier.services.Station station;

    public HistCarb() {
    }

    public HistCarb(
           com.atelier.services.Carburant carburant,
           java.util.Calendar date,
           int histcarbid,
           double prix,
           com.atelier.services.Station station) {
           this.carburant = carburant;
           this.date = date;
           this.histcarbid = histcarbid;
           this.prix = prix;
           this.station = station;
    }


    /**
     * Gets the carburant value for this HistCarb.
     * 
     * @return carburant
     */
    public com.atelier.services.Carburant getCarburant() {
        return carburant;
    }


    /**
     * Sets the carburant value for this HistCarb.
     * 
     * @param carburant
     */
    public void setCarburant(com.atelier.services.Carburant carburant) {
        this.carburant = carburant;
    }


    /**
     * Gets the date value for this HistCarb.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this HistCarb.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the histcarbid value for this HistCarb.
     * 
     * @return histcarbid
     */
    public int getHistcarbid() {
        return histcarbid;
    }


    /**
     * Sets the histcarbid value for this HistCarb.
     * 
     * @param histcarbid
     */
    public void setHistcarbid(int histcarbid) {
        this.histcarbid = histcarbid;
    }


    /**
     * Gets the prix value for this HistCarb.
     * 
     * @return prix
     */
    public double getPrix() {
        return prix;
    }


    /**
     * Sets the prix value for this HistCarb.
     * 
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }


    /**
     * Gets the station value for this HistCarb.
     * 
     * @return station
     */
    public com.atelier.services.Station getStation() {
        return station;
    }


    /**
     * Sets the station value for this HistCarb.
     * 
     * @param station
     */
    public void setStation(com.atelier.services.Station station) {
        this.station = station;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HistCarb)) return false;
        HistCarb other = (HistCarb) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.carburant==null && other.getCarburant()==null) || 
             (this.carburant!=null &&
              this.carburant.equals(other.getCarburant()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            this.histcarbid == other.getHistcarbid() &&
            this.prix == other.getPrix() &&
            ((this.station==null && other.getStation()==null) || 
             (this.station!=null &&
              this.station.equals(other.getStation())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCarburant() != null) {
            _hashCode += getCarburant().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        _hashCode += getHistcarbid();
        _hashCode += new Double(getPrix()).hashCode();
        if (getStation() != null) {
            _hashCode += getStation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HistCarb.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.atelier.com/", "histCarb"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carburant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carburant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.atelier.com/", "carburant"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("histcarbid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "histcarbid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("station");
        elemField.setXmlName(new javax.xml.namespace.QName("", "station"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services.atelier.com/", "station"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
