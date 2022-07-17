/**
 * ListaResp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

 package org.profamilia.hc.sap.webservice.consultaservicio;

public class ListaResp  implements java.io.Serializable {
    private T_Inf[] t_List;

    private T_Return[] t_Return;

    public ListaResp() {
    }

    public ListaResp(
           T_Inf[] t_List,
           T_Return[] t_Return) {
           this.t_List = t_List;
           this.t_Return = t_Return;
    }


    /**
     * Gets the t_List value for this ListaResp.
     * 
     * @return t_List
     */
    public T_Inf[] getT_List() {
        return t_List;
    }


    /**
     * Sets the t_List value for this ListaResp.
     * 
     * @param t_List
     */
    public void setT_List(T_Inf[] t_List) {
        this.t_List = t_List;
    }

    public T_Inf getT_List(int i) {
        return this.t_List[i];
    }

    public void setT_List(int i, T_Inf _value) {
        this.t_List[i] = _value;
    }


    /**
     * Gets the t_Return value for this ListaResp.
     * 
     * @return t_Return
     */
    public T_Return[] getT_Return() {
        return t_Return;
    }


    /**
     * Sets the t_Return value for this ListaResp.
     * 
     * @param t_Return
     */
    public void setT_Return(T_Return[] t_Return) {
        this.t_Return = t_Return;
    }

    public T_Return getT_Return(int i) {
        return this.t_Return[i];
    }

    public void setT_Return(int i, T_Return _value) {
        this.t_Return[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaResp)) return false;
        ListaResp other = (ListaResp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.t_List==null && other.getT_List()==null) || 
             (this.t_List!=null &&
              java.util.Arrays.equals(this.t_List, other.getT_List()))) &&
            ((this.t_Return==null && other.getT_Return()==null) || 
             (this.t_Return!=null &&
              java.util.Arrays.equals(this.t_Return, other.getT_Return())));
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
        if (getT_List() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_List());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_List(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getT_Return() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_Return());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_Return(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaResp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:listaprecios:clinico:sap", "ListaResp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_List");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_List"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:listaprecios:clinico:sap", "T_Inf"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_Return");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_Return"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:listaprecios:clinico:sap", "T_Return"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
