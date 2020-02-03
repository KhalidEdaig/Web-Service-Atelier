/**
 * Station.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atelier.services;

public class Station  implements java.io.Serializable {
    private int stid;

    private java.lang.String stNom;

    private java.lang.String stVillle;

    private java.lang.String stAddress;

    public Station() {
    }

    public Station(
           int stid,
           java.lang.String stNom,
           java.lang.String stVillle,
           java.lang.String stAddress) {
           this.stid = stid;
           this.stNom = stNom;
           this.stVillle = stVillle;
           this.stAddress = stAddress;
    }


    /**
     * Gets the stid value for this Station.
     * 
     * @return stid
     */
    public int getStid() {
        return stid;
    }


    /**
     * Sets the stid value for this Station.
     * 
     * @param stid
     */
    public void setStid(int stid) {
        this.stid = stid;
    }


    /**
     * Gets the stNom value for this Station.
     * 
     * @return stNom
     */
    public java.lang.String getStNom() {
        return stNom;
    }


    /**
     * Sets the stNom value for this Station.
     * 
     * @param stNom
     */
    public void setStNom(java.lang.String stNom) {
        this.stNom = stNom;
    }


    /**
     * Gets the stVillle value for this Station.
     * 
     * @return stVillle
     */
    public java.lang.String getStVillle() {
        return stVillle;
    }


    /**
     * Sets the stVillle value for this Station.
     * 
     * @param stVillle
     */
    public void setStVillle(java.lang.String stVillle) {
        this.stVillle = stVillle;
    }


    /**
     * Gets the stAddress value for this Station.
     * 
     * @return stAddress
     */
    public java.lang.String getStAddress() {
        return stAddress;
    }


    /**
     * Sets the stAddress value for this Station.
     * 
     * @param stAddress
     */
    public void setStAddress(java.lang.String stAddress) {
        this.stAddress = stAddress;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Station)) return false;
        Station other = (Station) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.stid == other.getStid() &&
            ((this.stNom==null && other.getStNom()==null) || 
             (this.stNom!=null &&
              this.stNom.equals(other.getStNom()))) &&
            ((this.stVillle==null && other.getStVillle()==null) || 
             (this.stVillle!=null &&
              this.stVillle.equals(other.getStVillle()))) &&
            ((this.stAddress==null && other.getStAddress()==null) || 
             (this.stAddress!=null &&
              this.stAddress.equals(other.getStAddress())));
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
        _hashCode += getStid();
        if (getStNom() != null) {
            _hashCode += getStNom().hashCode();
        }
        if (getStVillle() != null) {
            _hashCode += getStVillle().hashCode();
        }
        if (getStAddress() != null) {
            _hashCode += getStAddress().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Station.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.atelier.com/", "station"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stNom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stNom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stVillle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stVillle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAddress"));
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
