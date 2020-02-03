/**
 * Carburant.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atelier.services;

public class Carburant  implements java.io.Serializable {
    private int carbid;

    private java.lang.String carbNom;

    private java.lang.String carbDescription;

    public Carburant() {
    }

    public Carburant(
           int carbid,
           java.lang.String carbNom,
           java.lang.String carbDescription) {
           this.carbid = carbid;
           this.carbNom = carbNom;
           this.carbDescription = carbDescription;
    }


    /**
     * Gets the carbid value for this Carburant.
     * 
     * @return carbid
     */
    public int getCarbid() {
        return carbid;
    }


    /**
     * Sets the carbid value for this Carburant.
     * 
     * @param carbid
     */
    public void setCarbid(int carbid) {
        this.carbid = carbid;
    }


    /**
     * Gets the carbNom value for this Carburant.
     * 
     * @return carbNom
     */
    public java.lang.String getCarbNom() {
        return carbNom;
    }


    /**
     * Sets the carbNom value for this Carburant.
     * 
     * @param carbNom
     */
    public void setCarbNom(java.lang.String carbNom) {
        this.carbNom = carbNom;
    }


    /**
     * Gets the carbDescription value for this Carburant.
     * 
     * @return carbDescription
     */
    public java.lang.String getCarbDescription() {
        return carbDescription;
    }


    /**
     * Sets the carbDescription value for this Carburant.
     * 
     * @param carbDescription
     */
    public void setCarbDescription(java.lang.String carbDescription) {
        this.carbDescription = carbDescription;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Carburant)) return false;
        Carburant other = (Carburant) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.carbid == other.getCarbid() &&
            ((this.carbNom==null && other.getCarbNom()==null) || 
             (this.carbNom!=null &&
              this.carbNom.equals(other.getCarbNom()))) &&
            ((this.carbDescription==null && other.getCarbDescription()==null) || 
             (this.carbDescription!=null &&
              this.carbDescription.equals(other.getCarbDescription())));
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
        _hashCode += getCarbid();
        if (getCarbNom() != null) {
            _hashCode += getCarbNom().hashCode();
        }
        if (getCarbDescription() != null) {
            _hashCode += getCarbDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Carburant.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.atelier.com/", "carburant"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carbid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carbid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carbNom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carbNom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carbDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carbDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
