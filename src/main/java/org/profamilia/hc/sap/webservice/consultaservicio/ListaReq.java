/**
 * ListaReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

 package org.profamilia.hc.sap.webservice.consultaservicio;

public class ListaReq  implements java.io.Serializable {
    private java.lang.String material;

    private java.lang.String orgVentas;

    private java.lang.String canalDist;

    public ListaReq() {
    }

    public ListaReq(
           java.lang.String material,
           java.lang.String orgVentas,
           java.lang.String canalDist) {
           this.material = material;
           this.orgVentas = orgVentas;
           this.canalDist = canalDist;
    }


    /**
     * Gets the material value for this ListaReq.
     * 
     * @return material
     */
    public java.lang.String getMaterial() {
        return material;
    }


    /**
     * Sets the material value for this ListaReq.
     * 
     * @param material
     */
    public void setMaterial(java.lang.String material) {
        this.material = material;
    }


    /**
     * Gets the orgVentas value for this ListaReq.
     * 
     * @return orgVentas
     */
    public java.lang.String getOrgVentas() {
        return orgVentas;
    }


    /**
     * Sets the orgVentas value for this ListaReq.
     * 
     * @param orgVentas
     */
    public void setOrgVentas(java.lang.String orgVentas) {
        this.orgVentas = orgVentas;
    }


    /**
     * Gets the canalDist value for this ListaReq.
     * 
     * @return canalDist
     */
    public java.lang.String getCanalDist() {
        return canalDist;
    }


    /**
     * Sets the canalDist value for this ListaReq.
     * 
     * @param canalDist
     */
    public void setCanalDist(java.lang.String canalDist) {
        this.canalDist = canalDist;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaReq)) return false;
        ListaReq other = (ListaReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.material==null && other.getMaterial()==null) || 
             (this.material!=null &&
              this.material.equals(other.getMaterial()))) &&
            ((this.orgVentas==null && other.getOrgVentas()==null) || 
             (this.orgVentas!=null &&
              this.orgVentas.equals(other.getOrgVentas()))) &&
            ((this.canalDist==null && other.getCanalDist()==null) || 
             (this.canalDist!=null &&
              this.canalDist.equals(other.getCanalDist())));
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
        if (getMaterial() != null) {
            _hashCode += getMaterial().hashCode();
        }
        if (getOrgVentas() != null) {
            _hashCode += getOrgVentas().hashCode();
        }
        if (getCanalDist() != null) {
            _hashCode += getCanalDist().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:listaprecios:clinico:sap", "ListaReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("material");
        elemField.setXmlName(new javax.xml.namespace.QName("", "material"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgVentas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgVentas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canalDist");
        elemField.setXmlName(new javax.xml.namespace.QName("", "canalDist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
